; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 0  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}import java.util.Random;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public abstract class Dice `{
Send {Enter}
Sleep, 10
Send {Text}    private Random random = new Random();
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    protected int getRandomNumber(int lowerBound, int upperBound) `{
Send {Enter}
Sleep, 10
Send {Text}        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    public abstract int roll();
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    public String getName() `{
Send {Enter}
Sleep, 10
Send {Text}        return getClass().getSimpleName();
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
