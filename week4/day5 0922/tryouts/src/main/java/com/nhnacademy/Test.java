package com.nhnacademy;

public class Test {
    public static void main(String[] args) {
        


        
    }


    boolean rowchk = true;
    // 가로줄
    for(
    String[] row:chkBoard)
    {
        String firstRow = row[0];
        for (String cell : row) {
            if (cell == "") {
                rowchk = false;
                // 틀림
            }
            if (cell != firstRow) {
                rowchk = false;
                // 틀림
            }

        }
        if (rowchk == true) {
            // 승리자 판별
        }
    }


    // 세로줄
    // 자신의 열 그러나까 n열끼리 비교
    // 해당 열의 첫번째 행의 값을 체크
    // 해당 열의 첫번째 행의 값이 ""이 아니라면, 해당 값을 저장
    // 이후 해당 열의 나머지 행의 값을 이 값과 비교하기
    // '열'을 기준으로 '행'을 비교
    // j : 열 , i : 행



    for(
    int j = 0;j<3;j++)
    {

        // 열 체크

        boolean columnchk = true;
        String chk = chkBoard[1][j];
        for (int i = 0; i < 3; i++) {
            if (chk == "") {
                columnchk = false;
                break;
                // 틀림
            }
            if (chkBoard[i][j] != chk) {
                columnchk = false;
                // 틀림
            }
        }
        if (columnchk == true) {
            // 승리자 저장
        }
    }


    // 대각선 체크
    // 정중앙 체크 후 나머지 값이 정중앙 값과 같으면 승리자 저장

    String midchk = "";if(chkBoard[1][1]!="")
    {
        midchk = chkBoard[1][1];

        // 대각선 1
        if (chkBoard[0][0] == midchk && chkBoard[2][2] == midchk) {
            // 승리자 저장
        }
        // 대각선 2
        else if (chkBoard[2][0] == midchk && chkBoard[0][2] == midchk) {
            // 승리자 저장
        }

    }

}
