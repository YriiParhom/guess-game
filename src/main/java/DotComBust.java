import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Ваша цель - потопить три сайта.");
        System.out.println("Pets.com, eToys.com и Go.com");
        System.out.println("попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComTest : dotComList) {
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")){
                dotComList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Все Сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18){
            System.out.println("Эзаняло у вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того как ваши вложения утонули.");
        } else  {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }
}
