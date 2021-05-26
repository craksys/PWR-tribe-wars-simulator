package Unit;

public class UnitDetails {
    public String type; // rasa grupy jednostek
    public int hunger; // procenty
    public int stone; // procenty
    public int iron; // procenty
    public int wood; // procenty
    public int gold; // ilość złotych monet
    public int quantity; // liczebność grupy
    public boolean stationary = false; //koczownicy czy stacjonarni
    public int xPosition; // pozycja x
    public int yPosition; // pozycja y
    public int xScoutsPosition; // pozycja x grupy zwiadowczej jesli grupa jest stacjonarna
    public int yScoutsPosition; // pozycja y grupy zwiadowczej jesli grupa jest stacjonarna
    public boolean active = true; // czy jednostka zyje
    public boolean targetActive; // czy jednostka ma aktywny cel
    public int xTarget; // pozycja x potrzeby
    public int yTarget; // pozycja y potrzeby
    public int targetType; // jakiego surowca potrzebuje jednostka
}
