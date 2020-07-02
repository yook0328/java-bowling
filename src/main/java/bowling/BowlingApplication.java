package bowling;

import bowling.game.frame.Frames;
import bowling.game.ScoreBoard;
import bowling.game.Scores;
import bowling.player.domain.Player;
import bowling.view.InputView;
import bowling.view.OutputView;

import java.util.Arrays;

public class BowlingApplication {
    public static void main(String[] args) {
        String name = InputView.inputName();
        Player player = new Player(name);

        ScoreBoard scoreBoard = new ScoreBoard(Arrays.asList(player));
        Frames frames = scoreBoard.findByPlayer(player);
        Scores scores = new Scores(frames.getScores());

        OutputView.printScoreBoard(player, frames, scores);

        while (!frames.isEndAllFrames()) {
            int frameNumber = frames.getCurrentFrameNumber();
            frames.bowlCurrentFrame(InputView.inputPinCount(frameNumber));
            scores = new Scores(frames.getScores());

            OutputView.printScoreBoard(player, frames, scores);
        }
    }
}