public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int pointsPlayer1, int PointsPlayer2) {

        if (isTie(pointsPlayer1, PointsPlayer2)) {
            return getTieScore(pointsPlayer1);
        }
        else if (isAdvantageorWin(pointsPlayer1, PointsPlayer2))
        {
            return getAdvantageorWinScores(pointsPlayer1, PointsPlayer2);
        }
        else
        {
            return getPuntuacionSinVentajaoEmpate(pointsPlayer1, PointsPlayer2);

        }
    }
        private static String getPuntuacionSinVentajaoEmpate(int pointsPlayer1, int pointsPlayer2 ) {
            String score = "";
        score = getRegularScores(pointsPlayer1, score);
        score +="-";
        pointsPlayer1 = pointsPlayer2;
        score = getRegularScores(pointsPlayer1, score);
        return score;
    }


    private static String getRegularScores(int pointsPlayer1, String score ) {

            switch(pointsPlayer1)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }

        return score;
    }


    private static String getAdvantageorWinScores(int pointsPlayer1, int PointsPlayer2) {
        String score = "";
        int minusResult = pointsPlayer1 - PointsPlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static boolean isAdvantageorWin(int pointsPlayer1, int PointsPlayer2) {
        return pointsPlayer1 >= 4 || PointsPlayer2 >= 4;
    }

    private static String getTieScore(int pointsPlayers) {
        switch (pointsPlayers)
        {
            case 0:
               return "Love-All";

            case 1:
                return  "Fifteen-All";

            case 2:
                return "Thirty-All";

            case 3:
                return "Forty-All";

            default:
                return "Deuce";


        }
    }

    private static boolean isTie(int pointsPlayer1, int PointsPlayer2) {
        return pointsPlayer1 == PointsPlayer2;
    }
}