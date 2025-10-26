; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 10  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}import java.lang.Math;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class MultisidedDice extends Dice `{
Send {Enter}
Sleep, 10
Send {Text}  final protected int lowerBound;
Send {Enter}
Sleep, 10
Send {Text}  final protected int upperBound;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public MultisidedDice(int _lowerBound, int _upperBound) `{
Send {Enter}
Sleep, 10
Send {Text}    final int min = 4;
Send {Enter}
Sleep, 10
Send {Text}    final int max = 20;
Send {Enter}
Sleep, 10
Send {Text}    this.lowerBound = Math.min(Math.max(min, _lowerBound), max);
Send {Enter}
Sleep, 10
Send {Text}    this.upperBound = Math.min(Math.max(this.lowerBound, _upperBound), max);
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  @Override
Send {Enter}
Sleep, 10
Send {Text}  public int roll() `{
Send {Enter}
Sleep, 10
Send {Text}    return getRandomNumber(this.lowerBound, this.upperBound);
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
