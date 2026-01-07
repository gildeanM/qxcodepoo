public class Shell {
    public static void main(String[] arg) {
        System.out.println("side_by_side=080");
        
        Agiota agiota = new Agiota();

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      (line[0].equals("end"))     { break; }
            else if (line[0].equals("init"))    { agiota = new Agiota(); }
            else if (line[0].equals("show"))    { IO.print(agiota); }
            else if (line[0].equals("showCli")) { IO.print( agiota.getClient( line[1] ) ); }
            else if (line[0].equals("addCli"))  { try{agiota.addClient( line[1], IO.strToInt(line[2]) );}catch(Exception e){IO.println(e.getMessage());} }
            else if (line[0].equals("give"))    { try{agiota.give( line[1], IO.strToInt(line[2]) );}catch(Exception e){IO.println(e.getMessage());} }
            else if (line[0].equals("take"))    { try{agiota.take( line[1], IO.strToInt(line[2]) );}catch(Exception e){IO.println(e.getMessage());} }
            else if (line[0].equals("kill"))    { agiota.kill( line[1] ); }
            else if (line[0].equals("plus"))    { agiota.plus(); }
            else                                { IO.println("fail: comando invalido"); }
        }
    }
}
