package be.ewon;

public class Frame {
    protected static final String STRIKE = "X";
    protected static final String SPARE = "/";
    protected static final String SEPARATOR = ", ";
    protected static final String EQUALS = " = ";
    protected static final String LINEBREAK = "\n";
    protected static final String TOTAL_NOT_COMPLETE = " - ";

    protected static final int STRIKE_OR_SPARE_POINTS = 10;

    private Integer firstThrow;
    private Integer secondThrow;
    private int total;
    private boolean isLastFrame;

    public Frame(Integer firstThrow) {
        this.firstThrow = firstThrow;
    }

    public Integer getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(Integer firstThrow) {
        this.firstThrow = firstThrow;
    }

    public Integer getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(Integer secondThrow) {
        this.secondThrow = secondThrow;
    }

    public boolean isLastFrame() {
        return isLastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        isLastFrame = lastFrame;
    }

    public void addThrow(int pinsKnocked) {
        if (getFirstThrow() == null) {
            setFirstThrow(pinsKnocked);
        } else if (getSecondThrow() == null) {
            setSecondThrow(pinsKnocked);
        }
    }

    public int getTotalFrame() {
        if (getSecondThrow() == null) {
            return getFirstThrow();
        } else {
            return getFirstThrow() + getSecondThrow();
        }
    }

    public int getTotalFrameToReport() {
        if (getSecondThrow() == null) {
            return getFirstThrow();
        } else {
            return getFirstThrow() + getSecondThrow();
        }
    }

    public boolean isAStrike() {
        return getFirstThrow() == STRIKE_OR_SPARE_POINTS;
    }

    public boolean isASpare() {
        return getTotalFrameToReport() == STRIKE_OR_SPARE_POINTS && getFirstThrow() != STRIKE_OR_SPARE_POINTS;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addScoreToTotal(int scoreToAdd) {
        this.total += scoreToAdd;
    }

    public void computeTotal(Frame lastFrame) {
        if (lastFrame != null) {
            setTotal(lastFrame.getTotal() + getTotalFrame());
        } else {
            setTotal(getTotalFrame());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isASpare()) {
            sb.append(getOutput(getFirstThrow())).append(SEPARATOR).append(SPARE);
        } else if (isAStrike()) {
            sb.append(STRIKE);
        } else {
            sb.append(getOutput(getFirstThrow())).append(SEPARATOR);
            if (getSecondThrow() != null) {
                sb.append(getOutput(getSecondThrow()));
            }
        }
        if (isLastFrame() && (isAStrike() || isASpare())) {
            sb.append(EQUALS).append(TOTAL_NOT_COMPLETE).append(LINEBREAK);
        } else if (getSecondThrow() != null || isAStrike()) {
            sb.append(EQUALS).append(getTotal()).append(LINEBREAK);
        } else {
            sb.append(EQUALS).append(TOTAL_NOT_COMPLETE).append(LINEBREAK);
        }
        return sb.toString();
    }

    protected String getOutput(int score) {
        if (score == 0) {
            return "-";
        } else {
            return "" + score;
        }
    }
}
