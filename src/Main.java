public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     */
    public static String getScore(int pointsPlayer1, int PointsPlayer2) {
        int tempScore=0;

        if (isTie(pointsPlayer1, PointsPlayer2)) {
            return getTieScore(pointsPlayer1);
        }
        else if (isAdvantageorWin(pointsPlayer1, PointsPlayer2))
        {
            return getAdvantageorWinScores(pointsPlayer1, PointsPlayer2);
        }
        else
        {
            return getRegularScores(pointsPlayer1, PointsPlayer2);

        }
    }

    private static String getRegularScores(int pointsPlayer1, int PointsPlayer2) {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = pointsPlayer1;
            else { score +="-"; tempScore = PointsPlayer2;}
            switch(tempScore)
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

    private static String getTieScore(int pointsPlayer1) {
        String score = "";
        switch (pointsPlayer1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static boolean isTie(int pointsPlayer1, int PointsPlayer2) {
        return pointsPlayer1 == PointsPlayer2;
    }
}