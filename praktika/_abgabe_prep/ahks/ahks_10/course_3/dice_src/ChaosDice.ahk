; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 10  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class ChaosDice extends Dice `{
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  int lowerBound;
Send {Enter}
Sleep, 10
Send {Text}  int upperBound;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public ChaosDice() `{
Send {Enter}
Sleep, 10
Send {Text}    this.lowerBound = 0;
Send {Enter}
Sleep, 10
Send {Text}    this.upperBound = 20;
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
Send {Text}    final int min = 0;
Send {Enter}
Sleep, 10
Send {Text}    final int max = 20;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    int out = getRandomNumber(this.lowerBound, this.upperBound);
Send {Enter}
Sleep, 10
Send {Text}    this.lowerBound = getRandomNumber(min, max);
Send {Enter}
Sleep, 10
Send {Text}    this.upperBound = getRandomNumber(this.lowerBound, max);
Send {Enter}
Sleep, 10
Send {Text}    return out;
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
