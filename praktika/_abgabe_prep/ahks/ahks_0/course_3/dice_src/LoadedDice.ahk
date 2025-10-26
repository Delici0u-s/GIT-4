; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 0  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class LoadedDice extends Dice `{
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public LoadedDice() `{
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
Send {Text}    final int max = 6;
Send {Enter}
Sleep, 10
Send {Text}    if (getRandomNumber(0, 1) == 0) `{
Send {Enter}
Sleep, 10
Send {Text}      return max;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}    return getRandomNumber(min, max);
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
