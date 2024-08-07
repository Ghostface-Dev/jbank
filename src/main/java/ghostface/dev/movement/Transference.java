package ghostface.dev.movement;

import ghostface.dev.core.Account;
import ghostface.dev.core.Movement;
import org.jetbrains.annotations.NotNull;

public final class Transference extends Movement {
    private final @NotNull Account receiver;

    public Transference(int id, @NotNull Account from, double value, @NotNull Account to) {
        super(id, from, value);
        receiver = to;
        operation(value);
    }

    @Override
    protected void operation(double value) {
        receiver.setBalance(receiver.getBalance() + value);
        getFrom().setBalance(getFrom().getBalance() - value);
    }



}
