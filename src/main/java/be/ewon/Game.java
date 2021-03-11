package be.ewon;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public Game() {
        //empty constructor
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }

    public Frame getCurrentFrame() {
        return this.frames.get(this.frames.size() - 1);
    }

    public Frame getPreviousFrame() {
        if (frames.size() > 1) {
            return this.frames.get(this.frames.size() - 2);
        } else {
            return null;
        }
    }

    public Frame getSecondPreviousFrame() {
        if (frames.size() > 2) {
            return this.frames.get(this.frames.size() - 3);
        } else {
            return null;
        }
    }

    public void adaptScore() {
        if (getPreviousFrame() != null) {
            if (getPreviousFrame().isAStrike()) {
                getPreviousFrame().addScoreToTotal(getCurrentFrame().getTotalFrameToReport());
            } else if (getPreviousFrame().isASpare()) {
                getPreviousFrame().addScoreToTotal(getCurrentFrame().getFirstThrow());
            }
            if (getSecondPreviousFrame() != null && getSecondPreviousFrame().isAStrike() && getPreviousFrame().isAStrike()) {
                getSecondPreviousFrame().addScoreToTotal(getCurrentFrame().getFirstThrow());
                getPreviousFrame().addScoreToTotal(getCurrentFrame().getFirstThrow());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int positionOfFrame = 1;
        for (Frame frame : frames) {
            sb.append(positionOfFrame).append(" : ");
            sb.append(frame);
            positionOfFrame++;
        }
        sb.append("-----------\n");
        sb.append(getCurrentFrame().getTotal());
        return sb.toString();
    }
}
