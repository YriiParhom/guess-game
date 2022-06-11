import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public String checkYourself(String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + " :(");
            }else {
                result = "Попал";
            }
        }
        return result;
    }
}
