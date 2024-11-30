import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int menu(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Gestión de biblioteca");
        System.out.println("1.Agregar libro a la biblioteca.");
        System.out.println("2. Actualizar ejemplares.");
        System.out.println("3.Mostrar informacion de todos los libros.");
        System.out.println("4.Buscar libro por autor");
        System.out.println("5.Buscar libro por inicial");
        System.out.println("6.Eliminar libro de la biblioteca");
        System.out.println("7. Salir");
        int opcion=sc.nextInt();
        return opcion;
    }

    public static void gestionMenu(int opcion){
        Biblioteca biblioteca=new Biblioteca();
        Scanner sc=new Scanner(System.in);
        while (opcion!=7) {

            switch (opcion) {
                case 1:
                    System.out.println("Dime el título del libro que deseas incorporar:");
                    String titulo=sc.nextLine();
                    System.out.println("Dime el autor del libro que deseas incorporar");
                    String autor=sc.nextLine();
                    System.out.println("Dime el número de ejemplares que incorporas:");
                    int nEjemplares=sc.nextInt();
                    //Limpiar el buffer
                    sc.nextLine();
                    Libro l=new Libro(titulo, autor, nEjemplares);
                    if (biblioteca.insertarLibro(l)){
                        System.out.println("Libro insertado correctamente");

                    }
                    else{
                        System.out.println("La biblioteca esta al máximo de su capacidad.");
                    }
                    break;
                case 2:
                    System.out.println("Dime el titulo del libro ");
                    String tituloL=sc.nextLine();
                    System.out.println("Dime el número de ejemplares a modificar");
                    int nEjem=sc.nextInt();
                    //Limpiar el buffer
                    sc.nextLine();
                    if (biblioteca.modificarEjemplares(tituloL,nEjem)){
                        System.out.println("Ejemplares modificados de forma correcta");
                    }
                    else{
                        System.out.println("El libro no está en la biblioteca");
                    }
                    break;
                case 3:
                    biblioteca.mostrarInformación();
                    break;
                case 4:
                    System.out.println("Dime el nombre del autor");
                    String autorB=sc.nextLine();
                    biblioteca.mostrarLibrosPorAutor(autorB);
                    break;
                case 5:
                    System.out.println("Dime la inicial del título del libro");
                    char inicial=sc.nextLine().charAt(0);
                    biblioteca.buscarLibroPorInicial(inicial);
                    break;
                case 6:
                    System.out.println("Dime el titulo del libro a eliminar ");
                    String tituloLEliminar=sc.nextLine();
                    if (biblioteca.borrarLibro(tituloLEliminar)){
                        System.out.println("Libro borrado correctamente");
                    }
                    else {
                        System.out.println("El libro no está en la biblioteca");
                    }
                    break;
                case 7:
                    System.out.println("Adios");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida");
                    opcion=menu();
            }
            opcion=menu();
        }
    }
    public static void main(String[] args) {
        gestionMenu(menu());
    }
}