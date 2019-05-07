package mum.cs472;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 4, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };

    private static int[] answers = {9, 8, 36, 13, 32};
    private int score = 0;

    public String getQuestion() {
        if (score >= questions.length) {
            return "";
        }
        return questions[score];
    }

    public boolean answerCompute(int answer) {
        if (score >= answers.length) {
            return false;
        } else if (answers[score] == answer) {
            score += 1;
            return true;
        } else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public boolean isFinish() {
        return score == answers.length;
    }
}
