public class Biblioteca {
    private  static final int MAXIMO_EJEMPLARES=100;
    private Libro[] libros;
    private int nLibro;
    //Constructores
    public Biblioteca() {
        libros=new Libro[MAXIMO_EJEMPLARES];
        nLibro=0;
    }
    //Método que devuelve true si inserta el libro en la biblioteca y false si no lo inserta por estar completa la biblioteca
    public boolean insertarLibro(Libro l){
        if (nLibro<MAXIMO_EJEMPLARES){
            libros[nLibro]=l;
            nLibro++;
            return true;
        }
        else {
            return false;
        }
    }
    //método que devuelve true si modifca el numero de ejemplares del libro cuyo nombre le pasamos cómo parametro y false en caso de no estar el libro en la biblioteca
    public boolean modificarEjemplares(String nombreL, int nejemplares){
        for (int i = 0; i < nLibro; i++) {
            if (libros[i].getTitulo().equals(nombreL)){
                libros[i].setnEjemplares(nejemplares);
                return true;
            }
        }
        return false;
    }
    //
    public void mostrarInformación(){
        System.out.println("Listado de libros de la biblioteca");
        for (int i = 0; i < nLibro; i++) {
            System.out.println(libros[i].toString());
        }
        System.out.println("La biblioteca tiene "+nLibro+" libros");
    }

    public void mostrarLibrosPorAutor(String autor){
        System.out.println("Listado de libros del autor "+autor);
        for (int i = 0; i < nLibro; i++) {
            if (libros[i].getAutor().equals(autor)) {
                System.out.println(libros[i].toString());
            }
        }
    }

    public void buscarLibroPorInicial(char inicial){
        System.out.println("Libros cuyo título empiezan por "+inicial);
        for (int i = 0; i < nLibro; i++) {
            if (libros[i].getTitulo().charAt(0)==inicial){
                System.out.println(libros[i].getTitulo());
            }

        }
    }

    public boolean borrarLibro(String titulo){
        Libro[] copiaLibros=new Libro[MAXIMO_EJEMPLARES];
        boolean encontrado=false;
        int i=0;
        while (i<nLibro){
            if(libros[i].getTitulo().equals(titulo)){
                encontrado=true;
               libros[i]=libros[i+1];
               i++;
            }
            else{
                libros[i]=libros[i];
            }
            i++;
        }
        //Falta quitar el útimo libro del array
        libros[nLibro]=new Libro();
        nLibro--;
        return encontrado;

    }


}
