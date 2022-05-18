package step2;

import java.util.function.BooleanSupplier;

import step2.domain.ladder.Height;
import step2.domain.ladder.Ladder;
import step2.domain.player.Players;
import step2.impl.RandomBooleanSupplier;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		BooleanSupplier supplier = new RandomBooleanSupplier();

		Players players = new Players(inputView.askPlayers());
		Height height = new Height(inputView.askHeight());
		inputView.close();

		Ladder ladder = new Ladder(players.numberOfPlayer(), height, supplier);

		outputView.showCreationResult(players, ladder);
	}
}
