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

    public String getFirstName()
    {
        return this.firstName;
    }

    public Player setFirstName(String firstName)
    {
        this.firstName = firstName;

        return this;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public Player setLastName(String lastName)
    {
        this.lastName = lastName;

        return this;
    }

    public float getOverall()
    {
        return this.overall;
    }

    public Player setOverall(float overall)
    {
        this.overall = overall;

        return this;
    }

    public String getFullName()
    {
        return this.getFirstName() +" "+ this.getLastName();
    }
}
