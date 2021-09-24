package TrabajoGrupal;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Proyecto {

    private static Scanner entradaEscaner = new Scanner(System.in);

    private static String[][] usuariosSistema = {{"1", "Jorge", "123456", "Administrador","Jorge Bardales"}, {"2", "Aldo", "654321", "Gerente","Aldo Lizarraga"},{"3","Darla","987654","Gerente","Darla Perez"}};
    private static String[][] datosTrabajadores = new String[30][5];
    //private static String [][] horasTrabajadas = new String[30][3];
    private static int [][] avanceTrabajador = new int[30][4];



    public static void main(String[] args) {
        mensajeBienvenida();
        String usuario, contrasenia;
        boolean estado = false;
        do {
            System.out.print("Ingrese su usuario: ");
            usuario = entradaEscaner.nextLine();
            System.out.print("Ingrese su Contraseña: ");
            contrasenia = entradaEscaner.nextLine();
            estado = autenticarAutorizar(usuario,contrasenia);

        } while (estado == false);
    }

    private static void login(){
        String usuario, contrasenia;
        boolean estado = false;
        do {
            mensajeBienvenida();
            entradaEscaner.nextLine();
            System.out.print("Ingrese su usuario: ");
            usuario = entradaEscaner.nextLine();
            System.out.print("Ingrese su Contraseña: ");
            contrasenia = entradaEscaner.nextLine();
            estado = autenticarAutorizar(usuario,contrasenia);
        } while (estado == false);
    }

    public static void mensajeBienvenida() {
        System.out.println("****************************************************");
        System.out.println("*****BIENVENIDO AL SISTEMA DE PLANILLA DE ISHOP*****");
        System.out.println("****************************************************");
    }

    public static boolean autenticarAutorizar(String usuario, String contrasenia){
        boolean usuarioCorrecto = false;
        boolean existeUsuario = false;
        //int cantUsuario = usuariosSistema.length;
        for (int i = 0; i < usuariosSistema.length; i++) {
            if (usuariosSistema[i][1].equals(usuario)) {
                    existeUsuario = true;
                if (usuariosSistema[i][2].equals(contrasenia)) {
                    usuarioCorrecto = true;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Bienvenido " + usuariosSistema[i][1] + " | Perfil: " + usuariosSistema[i][3]);
                    switch (usuariosSistema[i][3]) {
                        case "Administrador" -> ingresoModuloAdministrador(i + 1);
                        case "Gerente" -> ingresoModuloGerente(i + 1);
                    }
                    break;
                } else {
                    System.out.println("Contraseña equivocada. Intente de nuevo");
                    break;
                }
            }
        }
        if(existeUsuario == false && usuarioCorrecto == false) {
            System.out.println("Usuario equivocado");
        }
        return usuarioCorrecto;
    }

    public static void ingresoModuloAdministrador(int i){
        System.out.println("MENÚ ADMINISTRADOR");
        System.out.println("1. Agregar Trabajador");
        System.out.println("2. Listado de Empleados");
        System.out.println("3. Salir sesion");
        System.out.println("0. Apagar sistema");
        int opcion;
        do{
            System.out.print("Seleccione opción : ");
            opcion = entradaEscaner.nextInt();
            switch (opcion){
                case 0:
                    System.out.println("APAGADO EL SISTEMA");
                    break;
                case 1:
                    agregarTrabajador(i);
                    break;
                case 2:
                    listarTrabajadores(i);
                    break;
                case 3:
                    System.out.println("Esta saliendo de su sesion");
                    login();
                    break;
                default:
                    System.out.println("No existe la siguiente opción. Ingrese nuevamente");
                    break;
            }
        } while(opcion != 0);
        System.out.println("");
        System.out.println("");
        System.exit(1);
    }

    public static void ingresoModuloGerente(int i){
        System.out.println("MENÚ GERENTE");
        System.out.println("1. Registrar avance de trabajador");
        System.out.println("2. Listardo de empleados");
        System.out.println("3. Ver planilla de Empleados");
        System.out.println("4. Salir sesion");
        int opcion;
        do{
           System.out.print("Seleccione opción : ");
           opcion = entradaEscaner.nextInt();
           switch (opcion){
               case 1:

                   break;
               case 2:
                   listarTrabajadasporTienda(i);
                   break;
               case 3:

                   break;
               case 4:
                   System.out.println("Esta saliendo de su sesion");
                   break;
               default:
                   System.out.println("No existe la siguiente opción. Ingrese nuevamente");
                   break;
           }
       } while(opcion != 4);
        System.out.println("");
        System.out.println("");
        login();
    }

    //CAMBIAR ESTE METODO PARA PODER INGRESAR METODO AVANCE TRABAJADOR
    /*public static void registroHorasTrabajadas(int i){
        String horas, comentarioTrabajo;
        entradaEscaner.nextLine();
        System.out.print("Ingrese la cantidad trabajada hoy: " );
        horas = entradaEscaner.nextLine();
        System.out.print("Ingrese el trabajo realizado hoy: " );
        comentarioTrabajo = entradaEscaner.nextLine();
        int cantRegistros = 0;
        for (int x = 0; x < horasTrabajadas.length; x++){
            if(horasTrabajadas[x][0] != null)
                cantRegistros++;
        }
            horasTrabajadas[cantRegistros][0] = horas;
            horasTrabajadas[cantRegistros][1] = comentarioTrabajo;
            horasTrabajadas[cantRegistros][2] = String.valueOf(i);

        System.out.println("Hora de trabajo REGISTRADO!!");
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(i);
    }*/

    public static void listarTrabajadores(int i) {
        System.out.println("LISTA DE TRABAJADORES: " );
        int contador = 0;
        System.out.format("%-5s %-20s %-20s \n","N°","NOMBRE Y APELLIDO","PUESTO" );
        System.out.format("%-5s %-20s %-20s \n","--","-----------------","------" );
        for (int x = 0; x < usuariosSistema.length; x++){
            if(usuariosSistema[x][0] != null) {
                    System.out.format("%-5s %-20s %-20s \n",(contador + 1),usuariosSistema[x][4], usuariosSistema[x][3]);
            }
            contador++;
        }

        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null) {
                System.out.format("%-5s %-20s %-20s \n",(contador + 1), datosTrabajadores[x][1], datosTrabajadores[x][2]);
            }
            contador++;
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloAdministrador(i);
    }

    /*public static void listarHorasTrabajadas(int i){
        String codigoUsuario;
        entradaEscaner.nextLine();
        System.out.print("Ingrese el codigo del trabajador: " );
        codigoUsuario = entradaEscaner.nextLine();
        System.out.format("%-5s %-20s %-20s \n","N°","HORAS","TRABAJO REALIZADO" );
        System.out.format("%-5s %-20s %-20s \n","--","-----","-----------------" );
        for (int x = 0; x < horasTrabajadas.length; x++){
            if(horasTrabajadas[x][0] != null && horasTrabajadas[x][2].equals(codigoUsuario))

                    System.out.format("%-5s %-20s %-20s \n",(x+1),horasTrabajadas[x][0], horasTrabajadas[x][1] );
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloAdministrador(i);
    }*/

    /*public static void listarHorasTrabajadasporTrabajador(int codigoUsuario){
        System.out.format("%-5s %-20s %-20s \n","N°","HORAS","TRABAJO REALIZADO" );
        System.out.format("%-5s %-20s %-20s \n","--","-----","-----------------" );
        int numeracion = 0;
        for (int x = 0; x < horasTrabajadas.length; x++){
            if(horasTrabajadas[x][0] != null)
                if (horasTrabajadas[x][2].equals(String.valueOf(codigoUsuario)))
                    System.out.format("%-5s %-20s %-20s \n",(numeracion+1),horasTrabajadas[x][0],horasTrabajadas[x][1] );
                    numeracion++;
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(codigoUsuario);
    }*/

    public static void listarTrabajadasporTienda(int codigoUsuario){
        String codigoTienda;
        entradaEscaner.nextLine();
        System.out.print("Ingrese el codigo de la tienda: " );
        codigoTienda = entradaEscaner.nextLine();
        System.out.println("LISTA DE TRABAJADORES POR TIENDA "+ codigoTienda +": " );
        int contador = 0;
        System.out.format("%-5s %-20s %-20s \n","N°","NOMBRE Y APELLIDO","PUESTO" );
        System.out.format("%-5s %-20s %-20s \n","--","-----------------","------" );
        for (int x = 0; x < usuariosSistema.length; x++){
            if(usuariosSistema[x][0] != null) {
                System.out.format("%-5s %-20s %-20s \n",(contador + 1),usuariosSistema[x][4], usuariosSistema[x][3]);
            }
            contador++;
        }

        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null && datosTrabajadores[x][4].equals(codigoTienda)) {
                System.out.format("%-5s %-20s %-20s \n",(contador + 1), datosTrabajadores[x][1], datosTrabajadores[x][2]);
            }
            contador++;
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(codigoUsuario);
    }

    public static void agregarTrabajador(int i){
        String nombreTrabajador, puestoTrabajador, beneficiosTrabajador, codigoTienda;
        entradaEscaner.nextLine();
        System.out.print("Ingrese Nombre trabajador: " );
        nombreTrabajador = entradaEscaner.nextLine();
        System.out.print("Ingrese puesto: " );
        puestoTrabajador = entradaEscaner.nextLine();
        System.out.print("Ingrese beneficios trabajador: " );
        beneficiosTrabajador = entradaEscaner.nextLine();
        System.out.print("Ingrese el codigo de tienda: " );
        codigoTienda = entradaEscaner.nextLine();

        int cantRegistros2 = 0;
        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null)
                cantRegistros2++;
        }

        datosTrabajadores[cantRegistros2][0] = String.valueOf(cantRegistros2+1);
        datosTrabajadores[cantRegistros2][1] = nombreTrabajador;
        datosTrabajadores[cantRegistros2][2] = puestoTrabajador;
        datosTrabajadores[cantRegistros2][3] = beneficiosTrabajador;
        datosTrabajadores[cantRegistros2][4] = codigoTienda;

        System.out.println("Trabajador REGISTRADO!!");
        System.out.println("");
        System.out.println("");
        ingresoModuloAdministrador(i);

        /*for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null)
                System.out.println(datosTrabajadores[x][0]+ "          " +datosTrabajadores[x][1]+ "          " +datosTrabajadores[x][2]+ "          " +datosTrabajadores[x][3]+ "          " +datosTrabajadores[x][4]);
        }*/
    }

}

