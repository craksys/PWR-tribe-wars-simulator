package Unit;

public class Unit_Details {
    public String type; // rasa grupy jednostek
    public int hunger; // procenty
    public int stone; // procenty
    public int iron; // procenty
    public int wood; // procenty
    public int gold; // ilość złotych monet
    public int quantity; // liczebność grupy
    public boolean stationary = false; //koczownicy czy stacjonarni
    public int x_position; // pozycja x
    public int y_position; // pozycja y
    public int x_scouts_position; // pozycja x grupy zwiadowczej jesli grupa jest stacjonarna
    public int y_scouts_position; // pozycja y grupy zwiadowczej jesli grupa jest stacjonarna
    public boolean active = true; // czy jednostka zyje
    public boolean targetactive; // czy jednostka ma aktywny cel
    public int x_target; // pozycja x potrzeby
    public int y_target; // pozycja y potrzeby
    public int targettype; // jakiego surowca potrzebuje jednostka
}
