package lv.autentica.models;

public class Player
{
    private String firstName;

    private String lastName;

    private float overall;

    public Player(String firstName, String lastName, float overall)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.overall = overall;
    }

    public float getOverall()
    {
        return this.overall;
    }

    public String getFullName()
    {
        return this.firstName +" "+ this.lastName;
    }
}
