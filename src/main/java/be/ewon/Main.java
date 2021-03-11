package be.ewon;

public class Main {
    public static void main(String[] pinsKnockedArray) {
        launchGame(pinsKnockedArray);
    }

    private static void launchGame(String[] pinsKnocked) {
        Game game = new Game();
        int numberOfFrames = 1;
        for (int i = 0; i < pinsKnocked.length; i++) {
            if (numberOfFrames == 10) {
                game.addFrame(new TenthFrame(Integer.parseInt(pinsKnocked[i])));
                for (int j = 0; j < 2; j++) {
                    if (hasNextThrow(pinsKnocked, i)) {
                        i++;
                        game.getCurrentFrame().addThrow(Integer.parseInt(pinsKnocked[i]));
                    }
                }
            } else {
                game.addFrame(new Frame(Integer.parseInt(pinsKnocked[i])));
                if (hasNextThrow(pinsKnocked, i) && !game.getCurrentFrame().isAStrike()) {
                    i++;
                    game.getCurrentFrame().addThrow(Integer.parseInt(pinsKnocked[i]));
                }
            }

            game.adaptScore();
            game.getCurrentFrame().computeTotal(game.getPreviousFrame());
            game.getCurrentFrame().setLastFrame(i == pinsKnocked.length - 1);
            numberOfFrames++;
        }
        System.out.println(game);
    }

    private static boolean hasNextThrow(String[] pinsKnocked, int index) {
        return pinsKnocked.length - 1 >= index + 1;
    }
}
