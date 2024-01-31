import pymysql

# MySQL 데이터베이스 연결 정보
host_name = 'localhost'
db_name = 'DatamotionMovieDatabase'
user_name = 'root'
password = '0000'

# 연결할 데이터베이스
connection = pymysql.connect(host=host_name, user=user_name, password=password, db=db_name)
cursor = connection.cursor()

# 모든 테이블 이름 조회
cursor.execute("SHOW TABLES;")
tables = cursor.fetchall()

# 텍스트 파일로 저장
with open('database_structure.txt', 'w') as file:
    for table in tables:
        table_name = table[0]
        file.write(f'Table: {table_name}\n')

        # 테이블 구조 조회
        cursor.execute(f'DESCRIBE {table_name};')
        table_info = cursor.fetchall()

        for column in table_info:
            col_name, col_type, col_nullable, col_key, col_default, col_extra = column
            file.write(f'  Column Name: {col_name}, Column Type: {col_type}, Nullable: {col_nullable}, Key: {col_key}, Default: {col_default}, Extra: {col_extra}\n')

        # 첫 번째 행 조회
        cursor.execute(f'SELECT * FROM {table_name} LIMIT 1;')
        first_row = cursor.fetchone()

        if first_row:
            file.write('  First Row:\n')
            column_names = [column[0] for column in cursor.description]
            for col_name, value in zip(column_names, first_row):
                if value is None:
                    value = 'NULL'
                file.write(f'    {col_name}: {value}\n')
            
        file.write('\n')

# 연결 종료
cursor.close()
connection.close()
