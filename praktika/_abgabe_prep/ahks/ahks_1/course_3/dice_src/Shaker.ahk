; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 1  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}import java.util.ArrayList;
Send {Enter}
Sleep, 10
Send {Text}import java.util.List;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class Shaker `{
Send {Enter}
Sleep, 10
Send {Text}    private List<Dice> cup = new ArrayList<>();
Send {Enter}
Sleep, 10
Send {Text}    int noOfThrows = 0;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    public void addDice(Dice dice) `{
Send {Enter}
Sleep, 10
Send {Text}        cup.add(dice);
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    public void throwDice() `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("Throw " + ++noOfThrows + ":");
Send {Enter}
Sleep, 10
Send {Text}        for (int i = 0; i < cup.size(); i++) `{
Send {Enter}
Sleep, 10
Send {Text}            System.out.print(cup.get(i).getName() + " ");
Send {Enter}
Sleep, 10
Send {Text}            System.out.println(cup.get(i).roll());
Send {Enter}
Sleep, 10
Send {Text}        `}
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("\n");
Send {Enter}
Sleep, 10
Send {Text}        pause();
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    private void pause() `{
Send {Enter}
Sleep, 10
Send {Text}        try `{
Send {Enter}
Sleep, 10
Send {Text}            Thread.sleep(2000);
Send {Enter}
Sleep, 10
Send {Text}        `} catch (InterruptedException e) `{
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}        `}
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
