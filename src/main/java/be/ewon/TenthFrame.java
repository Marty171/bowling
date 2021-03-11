package be.ewon;

public class TenthFrame extends Frame {
    private static final String END_OF_INCOMPLETE_FRAME = EQUALS + TOTAL_NOT_COMPLETE + LINEBREAK;
    private Integer thirdThrow;

    public TenthFrame(Integer firstThrow) {
        super(firstThrow);
    }

    public Integer getThirdThrow() {
        return thirdThrow;
    }

    public void setThirdThrow(Integer thirdThrow) {
        this.thirdThrow = thirdThrow;
    }

    @Override
    public void addThrow(int pinsKnocked) {
        if (getFirstThrow() == null) {
            setFirstThrow(pinsKnocked);
        } else if (getSecondThrow() == null) {
            setSecondThrow(pinsKnocked);
        } else {
            setThirdThrow(pinsKnocked);
        }
    }

    @Override
    public int getTotalFrame() {
        if (getSecondThrow() == null) {
            return getFirstThrow();
        } else if (getThirdThrow() == null) {
            return getFirstThrow() + getSecondThrow();
        } else {
            return getFirstThrow() + getSecondThrow() + getThirdThrow();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((isAStrike(getFirstThrow()) ? STRIKE : getOutput(getFirstThrow()))).append(SEPARATOR);

        if (getSecondThrow() != null) {
            if (isAStrike(getSecondThrow())) {
                sb.append(STRIKE).append(SEPARATOR).append(manageThirdThrow());
            } else if (isASpare(getFirstThrow(), getSecondThrow())) {
                sb.append(SPARE).append(SEPARATOR).append(manageThirdThrow());
            } else if (isAStrike(getFirstThrow())) {
                sb.append(getOutput(getSecondThrow())).append(SEPARATOR).append(manageThirdThrow());
            } else {
                sb.append(getOutput(getSecondThrow())).append(EQUALS).append(getTotal()).append(LINEBREAK);
            }
        } else {
            sb.append(END_OF_INCOMPLETE_FRAME);
        }
        return sb.toString();
    }

    private boolean isASpare(Integer throw1, Integer throw2) {
        return throw1 + throw2 == STRIKE_OR_SPARE_POINTS && throw2 != 0;
    }

    private boolean isAStrike(Integer throw1) {
        return throw1 == STRIKE_OR_SPARE_POINTS;
    }

    private String manageThirdThrow() {
        if (getThirdThrow() != null) {
            if (isASpare(getSecondThrow(), getThirdThrow())) {
                return SPARE + EQUALS + getTotal() + LINEBREAK;
            } else {
                return (isAStrike(getThirdThrow()) ? STRIKE : getOutput(getThirdThrow())) + EQUALS + getTotal() + LINEBREAK;
            }
        } else {
            return END_OF_INCOMPLETE_FRAME;
        }
    }

}
