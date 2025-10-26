; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 10  ; Set typing speed

Send {Text}package hsd.inflab.dice;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class Main `{
Send {Enter}
Sleep, 10
Send {Text}  public static void main(String[] args) `{
Send {Enter}
Sleep, 10
Send {Text}    Shaker shaker = new Shaker();
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    /* this works as this is intended usage */
Send {Enter}
Sleep, 10
Send {Text}    shaker.addDice(new RegularDice());
Send {Enter}
Sleep, 10
Send {Text}    /* this works as this is intended usage */
Send {Enter}
Sleep, 10
Send {Text}    shaker.addDice(new MultisidedDice(0, 40)); /* resolves to 4, 20 */
Send {Enter}
Sleep, 10
Send {Text}    /* this works as this is intended usage */
Send {Enter}
Sleep, 10
Send {Text}    shaker.addDice(new LoadedDice());
Send {Enter}
Sleep, 10
Send {Text}    /* this works as this is intended usage */
Send {Enter}
Sleep, 10
Send {Text}    shaker.addDice(new ChaosDice());
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    /* This does now work, as Dice is an abstract class */
Send {Enter}
Sleep, 10
Send {Text}    // shaker.addDice(new Dice());
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    /*
Send {Enter}
Sleep, 10
Send {Text}     * this does not work, both do extend the same abstact class, but LoadedDice is
Send {Enter}
Sleep, 10
Send {Text}     * not an extended class of RegularDice, so this dont work
Send {Enter}
Sleep, 10
Send {Text}     */
Send {Enter}
Sleep, 10
Send {Text}    // LoadedDice ld = new RegularDice();
Send {Enter}
Sleep, 10
Send {Text}    /* This would work if ld would exist */
Send {Enter}
Sleep, 10
Send {Text}    // shaker.addDice(ld);
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    while (true) `{
Send {Enter}
Sleep, 10
Send {Text}      shaker.throwDice();
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
