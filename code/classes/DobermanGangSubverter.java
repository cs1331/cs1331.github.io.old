public class DobermanGangSubverter {

    public static void main(String[] args) {
        DobermanGang dg =
            new DobermanGang("Chloe");
        // http://en.wikipedia.org/wiki/The_Doberman_Gang
        dg.add(new Doberman("Dillinger"));
        dg.add(new Doberman("Bonnie"));
        dg.add(new Doberman("Clyde"));
        dg.add(new Doberman("Pretty Boy Floyd"));
        dg.add(new Doberman("Baby Face Nelson"));
        dg.add(new Doberman("Ma Barker"));

        System.out.println(dg);

        // td is a reference to dg's private
        // topDog instance variable
        Doberman td = dg.getTopDog();
        td.setName("Bailey");
        System.out.println(dg);

        // prettyBoy is a reference to dg's
        // private gang[3] instance variable
        Doberman prettyBoy = dg.get(3);
        prettyBoy.setName("Pink Floyd");
        System.out.println(dg);

        // array variables also references,
        // so can get an alias to whole array
        Doberman[] theGang = dg.getGang();
        // http://en.wikipedia.org/wiki/Teletubbies
        theGang[0] = new Doberman("Tinky Winky");
        theGang[1] = new Doberman("Dipsy");
        theGang[2] = new Doberman("Laa Laa");
        theGang[3] = new Doberman("Po");
        theGang[4] = new Doberman("Noo Noo");
        System.out.println(dg);
    }
}
