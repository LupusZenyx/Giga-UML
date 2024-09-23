

public class Testklasse
{
    public static void main (String args[])
    {
        Gleis gleich = new Gleis(13);

        Waggon waggon1 = new Waggon("Aachen");
        Waggon waggon2 = new Waggon("Bonn");
        Waggon waggon3 = new Waggon("Cottbus");
        Waggon waggon4 = new Waggon("Dresden");
        Waggon waggon5 = new Waggon("Essen");
        Waggon waggon6 = new Waggon("Fulda");

        Gleis gleis = new Gleis(13);

        System.out.println("\n -------- 1. Test : leerer Stack, 1 raus --------");
        System.out.println(gleis.entnehmen());

        System.out.println("\n -------- 2. Test : 2 rein, 3 raus --------");
        gleis.abstellen(waggon1);
        gleis.abstellen(waggon2);
        System.out.println(gleis.entnehmen().getZiel());
        System.out.println(gleis.entnehmen().getZiel());
        System.out.println(gleis.entnehmen());

        System.out.println("\n -------- 3. Test : 3 rein, 3 raus --------");
        gleis.abstellen(waggon3);
        gleis.abstellen(waggon4);
        gleis.abstellen(waggon5);
        System.out.println(gleis.entnehmen().getZiel());
        System.out.println(gleis.entnehmen().getZiel());
        System.out.println(gleis.entnehmen().getZiel());

        System.out.println("\n -------- 4. Test : rein/raus durcheinander --------");
        gleis.abstellen(waggon1);
        gleis.abstellen(waggon2);
        gleis.abstellen(waggon3);
        System.out.println(gleis.entnehmen().getZiel());
        System.out.println(gleis.entnehmen().getZiel());
        gleis.abstellen(waggon4);
        gleis.abstellen(waggon5);
        System.out.println(gleis.entnehmen().getZiel());
        gleis.abstellen(waggon6);
        System.out.println(gleis.entnehmen().getZiel());
    }
}
