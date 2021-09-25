package TrabajoGrupal;

//import java.util.Arrays;
import java.util.Scanner;

public class proyectofin {
    private static Scanner entradaEscaner = new Scanner(System.in);
    private static String[][] usuariosSistema = {{"1", "Jorge", "12","55442233", "Administrador","Jorge Bardales"}, {"2", "Aldo", "22", "44556677","Gerente","Aldo Lizarraga"},{"3","Darla","987654","66778899","Gerente","Darla Perez"}};
    private static String[][] datosTrabajadores = new String[30][9];
    private static String [][] avanceTrabajador = new String[30][12];


    public static void main(String[] args) {
        /*mensajeBienvenida();
        String usuario, contrasenia;
        boolean estado = false;
        do {
            System.out.print("Ingrese su usuario: ");
            usuario = entradaEscaner.nextLine();
            System.out.print("Ingrese su Contraseña: ");
            contrasenia = entradaEscaner.nextLine();
            estado = autenticarAutorizar(usuario,contrasenia);

        } while (estado == false);*/
        login();
    }

    private static void login(){
        mensajeBienvenida();
        String usuario, contrasenia;
        boolean estado = false;
        do {
            //entradaEscaner.nextLine();
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
        for (int i = 0; i < usuariosSistema.length; i++) {
            if (usuariosSistema[i][1].equals(usuario)) {
                existeUsuario = true;
                if (usuariosSistema[i][2].equals(contrasenia)) {
                    usuarioCorrecto = true;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Bienvenido " + usuariosSistema[i][1] + " | Perfil: " + usuariosSistema[i][4]);
                    switch (usuariosSistema[i][4]) {
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
        String opcion;
        do{
            System.out.print("Seleccione opción : ");
            opcion = entradaEscaner.nextLine();
            switch (opcion){
                case "0":
                    System.out.println("APAGADO EL SISTEMA");
                    break;
                case "1":
                    agregarTrabajador(i);
                    break;
                case "2":
                    listarTrabajadores(i);
                    break;
                case "3":
                    System.out.println("Esta saliendo de su sesion");
                    System.out.println("");
                    System.out.println("");
                    //entradaEscaner.nextLine();
                    login();
                    break;
                default:
                    System.out.println("No existe la siguiente opción. Ingrese nuevamente");
                    break;
            }
        } while(!opcion.equals("0"));
        System.out.println("");
        System.out.println("");
        System.exit(1);
    }

    public static void ingresoModuloGerente(int i){
        System.out.println("MENÚ GERENTE");
        System.out.println("1. Registrar avance de trabajador");
        System.out.println("2. Listado de empleado por tienda");
        System.out.println("3. Ver planilla de Empleados");
        System.out.println("4. Salir sesion");
        String opcion;
        do{
            System.out.print("Seleccione opción : ");
            opcion = entradaEscaner.nextLine();
            switch (opcion){
                case "1":
                    //entradaEscaner.nextLine();
                    registroAvanceTrabjador(i);
                    break;
                case "2":
                    listarTrabajadasporTienda(i);
                    break;
                case "3":
                    visualizarPlanilla(i);
                    break;
                case "4":
                    System.out.println("Esta saliendo de su sesión");
                    break;
                default:
                    System.out.println("No existe la siguiente opción. Ingrese nuevamente");
                    break;
            }
        } while(!opcion.equals("4"));
        System.out.println("");
        System.out.println("");
        //entradaEscaner.nextLine();
        login();
    }

    private static void visualizarPlanilla(int i) {
        String dniTrabjador;
        double sueldoBase=0.0;
        double remuMensual=0.0;
        double asigFam=0.0;
        double comision=0.0;
        double pension=0.0;
        double pensiononp =0;
        double pensionAdmi=0.0;
        double pensionSeg=0.0;
        double horasExtra=0.0;

        boolean existeTrabajador = false;
        //entradaEscaner.nextLine();
        do {
            System.out.print("Ingrese el DNI del trabajador: " );
            dniTrabjador = entradaEscaner.nextLine();
            for (int j = 0; j < datosTrabajadores.length; j++) {
                if(datosTrabajadores[j][2] != null && datosTrabajadores[j][2].equals(dniTrabjador)) {
                    existeTrabajador = true;
                }
            }
            if (existeTrabajador == false){
                System.out.println("El siguiente DNI ingresado no existe en la lista de trabajadores");
            }

        } while (existeTrabajador == false);



        int datoAvance =0;
        for (int j = 0; j <avanceTrabajador.length ; j++) {
            if (avanceTrabajador[j][0] != null) {
                if (avanceTrabajador[j][0].equals(dniTrabjador)) datoAvance=j;
            }
        }
        int datoTrabajador =0;
        for (int x = 0; x < datosTrabajadores.length ; x++) {
            if (datosTrabajadores[x][0] != null) {
                if (datosTrabajadores[x][2].equals(dniTrabjador)) datoTrabajador=x;
            }
        }

        if(datosTrabajadores[datoTrabajador][3].equals("1"))sueldoBase=1000;
        if(datosTrabajadores[datoTrabajador][3].equals("2"))sueldoBase=3500;
        if(datosTrabajadores[datoTrabajador][3].equals("3"))sueldoBase=2500;

        //Calculo de remuneración mensual
        remuMensual = (sueldoBase/30)* Integer.parseInt(avanceTrabajador[datoAvance][3]);

        //Cálculo ASignación Familiar
        if (datosTrabajadores[datoTrabajador][4].equals("Si")||datosTrabajadores[datoTrabajador][4].equals("si")){
            asigFam=93.00;
        }else   asigFam =0;

        //Cálculo Comisión
        comision= (Double.parseDouble(avanceTrabajador[datoAvance][5])/Double.parseDouble(avanceTrabajador[datoAvance][4]))*sueldoBase;

        //Cáculo AFP

        if(datosTrabajadores[datoTrabajador][7].equals("1")) pensiononp= (remuMensual+asigFam+comision+horasExtra)*0.13;
        if(datosTrabajadores[datoTrabajador][7].equals("2")){
            pension= (remuMensual+asigFam+comision+horasExtra)*0.10;
            pensionAdmi = (remuMensual+asigFam+comision+horasExtra)*0.0147;
            pensionSeg = (remuMensual+asigFam+comision+horasExtra)*0.0174;
        }
        if(datosTrabajadores[datoTrabajador][7].equals("2")){
            pension= (remuMensual+asigFam+comision+horasExtra)*0.10;
            pensionAdmi = (remuMensual+asigFam+comision+horasExtra)*0.0155;
            pensionSeg = (remuMensual+asigFam+comision+horasExtra)*0.0174;
        }
        if(datosTrabajadores[datoTrabajador][7].equals("3")){
            pension= (remuMensual+asigFam+comision+horasExtra)*0.10;
            pensionAdmi = (remuMensual+asigFam+comision+horasExtra)*0.0160;
            pensionSeg = (remuMensual+asigFam+comision+horasExtra)*0.0174;
        }
        if(datosTrabajadores[datoTrabajador][7].equals("4")){
            pension= (remuMensual+asigFam+comision+horasExtra)*0.10;
            pensionAdmi = (remuMensual+asigFam+comision+horasExtra)*0.0169;
            pensionSeg = (remuMensual+asigFam+comision+horasExtra)*0.0174;
        }

        //Cálculo Horas Extra
        if((Integer.parseInt(avanceTrabajador[datoAvance][1])-192)>0) {
            horasExtra= (sueldoBase/192)*(Integer.parseInt(avanceTrabajador[datoAvance][1])-192);
        }else horasExtra = 0;


        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("**********************************************************************************");
        System.out.println("****************************BOLETA DE REMUNERACIONES******************************");
        System.out.println("**********************************************************************************");

        System.out.format("%-20s %-25s %-15s %-15s \n","Trabajador: ", datosTrabajadores[datoTrabajador][1],"DNI: ", datosTrabajadores[datoTrabajador][2]);
        System.out.format("%-20s %-25s %-15s %-15s \n", "Código Tienda: " , datosTrabajadores[datoTrabajador][5],"Puesto: ",datosTrabajadores[datoTrabajador][3]);
        System.out.format("%-20s %-25s %-15s %-15s \n","Fecha de Ingreso: ", datosTrabajadores[datoTrabajador][8],"Sueldo Básico: ", sueldoBase);
        System.out.format("%-20s %-25s  \n","Periodo: " , avanceTrabajador[datoAvance][2]);
        System.out.format("%-20s %-25s %-15s %-15s \n","Días Trabajados: " , avanceTrabajador[datoAvance][3],"Horas Trabajadas: " , avanceTrabajador[datoAvance][1]);
        System.out.println("**********************************************************************************");
        System.out.println("******** INGRESOS *****************   *************** DESCUENTOS *****************");
        System.out.println("**********************************************************************************");
        System.out.format("%-25s %-20s %-25s %-30s \n","Remuneración Mensual:",String.format("%.2f",remuMensual),"ONP:" ,String.format("%.2f",pensiononp));
        System.out.format("%-25s %-20s %-25s %-30s \n","Asignación Familiar:",String.format("%.2f",asigFam),"AFP Fondo:",String.format("%.2f",pension));
        System.out.format("%-25s %-20s %-25s %-30s \n","Comisión:",String.format("%.2f",comision),"AFP Comisión:",String.format("%.2f",pensionAdmi));
        System.out.format("%-25s %-20s %-25s %-30s \n","Horas Extra:",String.format("%.2f",horasExtra), "AFP Seguro:",String.format("%.2f",pensionSeg));
        System.out.println("**********************************************************************************");
        System.out.format("%-25s %-20s %-25s %-30s \n","Total Ingresos:",String.format("%.2f",(remuMensual+asigFam+comision+horasExtra)),"Total Descuentos",String.format("%.2f",(pensiononp+pension+pensionAdmi+pensionSeg)) );
        System.out.println("**********************************************************************************");
        System.out.println("TOTAL NETO: "+ String.format("%.2f",((remuMensual+asigFam+comision+horasExtra)-(pensiononp+pension+pensionAdmi+pensionSeg)))+" Nuevos soles");
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(i);
    }

    public static void registroAvanceTrabjador(int i){

        String dniTrabajador, horas,mestrabajado, diasTrabajados, metaxTrabajador, alcaneTrabajador;
        boolean validarDni = false, validarMesAnio = false, validarDias = false, validarHorasMes = false, validarPropuesta = false, validarMontoAlcanzado = false;

        do {
            System.out.print("Ingrese el DNI del trabajador: " );
            dniTrabajador = entradaEscaner.nextLine();
            for (int j = 0; j < datosTrabajadores.length; j++) {
                if(datosTrabajadores[j][2] != null && datosTrabajadores[j][2].equals(dniTrabajador)) {
                    validarDni = true;
                }
            }
            if (validarDni == false){
                System.out.println("*El siguiente DNI ingresado no existe en la lista de trabajadores");
            }

        } while (validarDni == false);
        /*System.out.print("Ingrese el DNI del trabajador: " );
        entradaEscaner.nextLine();
        dniTrabajador = entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingresar mes y año actual MM/AAAA: " );
            mestrabajado = entradaEscaner.nextLine();
            if(mestrabajado.length() >= 7 && mestrabajado.substring(0,2).matches("[+-]?\\d*(\\.\\d+)?") && mestrabajado.substring(3,7).matches("[+-]?\\d*(\\.\\d+)?")) {
                if ((Integer.parseInt(mestrabajado.substring(0,2)) >= 1 &&  Integer.parseInt(mestrabajado.substring(0,2)) <= 12) && (Integer.parseInt(mestrabajado.substring(3,7)) >= 2000 &&  Integer.parseInt(mestrabajado.substring(3,7)) <= 2021) && mestrabajado.substring(2,3).equals("/")) {
                    validarMesAnio = true;
                } else {
                    System.out.println("*Por favor ingresar una fecha existente.");
                }
            } else {
                System.out.println("*Por favor ingresar el formato establecido.");
            }
        } while (validarMesAnio == false);
        /*System.out.println("Ingresar mes y año actual MM/AAAA: ");
        mestrabajado= entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingresar cantidad de días trabajados: " );
            diasTrabajados = entradaEscaner.nextLine();
            if(diasTrabajados.matches("[+-]?\\d*(\\.\\d+)?")) {
                validarDias = true;
            } else {
                System.out.println("*Por favor ingresar el dato correcto.");
            }
        } while (validarDias == false);
        /*System.out.println("Ingresar cantidad de días trabajados: ");
        diasTrabajados= entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingrese la cantidad horas trabajadas en el mes: " );
            horas = entradaEscaner.nextLine();
            if(horas.matches("[+-]?\\d*(\\.\\d+)?")) {
                validarHorasMes = true;
            } else {
                System.out.println("*Por favor ingresar el dato correcto.");
            }
        } while (validarHorasMes == false);
        /*System.out.print("Ingrese la cantidad horas trabajadas en el mes: " );
        horas = entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingrese la meta propuesta al trabajador: " );
            metaxTrabajador = entradaEscaner.nextLine();
            if(metaxTrabajador.matches("[+-]?\\d*(\\.\\d+)?")) {
                validarPropuesta = true;
            } else {
                System.out.println("*Por favor ingresar el dato correcto.");
            }
        } while (validarPropuesta == false);
        /*System.out.print("Ingrese la meta propuesta al trabajador: " );
        metaxTrabajador = entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingrese el monto alcanzado por el trabajador: " );
            alcaneTrabajador = entradaEscaner.nextLine();
            if(alcaneTrabajador.matches("[+-]?\\d*(\\.\\d+)?")) {
                validarMontoAlcanzado = true;
            } else {
                System.out.println("*Por favor ingresar el dato correcto.");
            }
        } while (validarMontoAlcanzado == false);
        /*System.out.print("Ingrese el monto alcanzado por el trabajador: " );
        alcaneTrabajador = entradaEscaner.nextLine();*/

        int cantRegistros3 = 0;
        for (int x = 0; x < avanceTrabajador.length; x++){
            if(avanceTrabajador[x][0] != null)
                cantRegistros3++;
        }
        int trabajador =0;
        for (int j = 0; j <datosTrabajadores.length ; j++) {
            if (datosTrabajadores[j][2] != null) {
                if (datosTrabajadores[j][2].equals(dniTrabajador)) {
                    trabajador=j;
                } else {
                    //System.out.println("No se encontró trabajador");
                }
            }
        }

        avanceTrabajador[cantRegistros3][0] = datosTrabajadores[trabajador][2]; //antes era [6]
        avanceTrabajador[cantRegistros3][1] = horas;
        avanceTrabajador[cantRegistros3][2] = mestrabajado;
        avanceTrabajador[cantRegistros3][3] = diasTrabajados;
        avanceTrabajador[cantRegistros3][4] = metaxTrabajador;
        avanceTrabajador[cantRegistros3][5] = alcaneTrabajador;
        System.out.println("");
        System.out.println("Se registraron "+avanceTrabajador[cantRegistros3][1] + " horas al usuario " + datosTrabajadores[trabajador][1]);
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(i);
    }

    public static void listarTrabajadores(int i) {
        System.out.println("LISTA DE TRABAJADORES: " );
        int contador = 0;
        System.out.format("%-5s %-20s %-10s %-20s \n","N°","NOMBRE Y APELLIDO","DNI", "PUESTO" );
        System.out.format("%-5s %-20s %-10s %-20s \n","--","-----------------","--------", "-------------" );
        for (int x = 0; x < usuariosSistema.length; x++){
            if(usuariosSistema[x][0] != null) {
                System.out.format("%-5s %-20s %-10s %-20s \n",(contador + 1),usuariosSistema[x][1], usuariosSistema[x][3],usuariosSistema[x][4]);
            }
            contador++;
        }
        String cargoUsuario = "";
        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null) {
                cargoUsuario = datosTrabajadores[x][3].equals("3") ? "Administrador" : (datosTrabajadores[x][3].equals("2") ? "Gerente" : "Vendedor");
                System.out.format("%-5s %-20s %-10s %-20s \n",(contador + 1), datosTrabajadores[x][1], datosTrabajadores[x][2], cargoUsuario);
            }
            contador++;
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloAdministrador(i);
    }

    public static void listarTrabajadasporTienda(int codigoUsuario){
        String codigoTienda;
        //entradaEscaner.nextLine();
        System.out.print("Ingrese el codigo de la tienda: " );
        codigoTienda = entradaEscaner.nextLine();
        System.out.println("LISTA DE TRABAJADORES POR TIENDA "+ codigoTienda +": " );
        int contador = 0;
        System.out.format("%-5s %-20s %-20s \n","N°","NOMBRE Y APELLIDO","PUESTO" );
        System.out.format("%-5s %-20s %-20s \n","--","-----------------","------" );

        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null) {
                if(datosTrabajadores[x][5].equals(codigoTienda))
                    System.out.format("%-5s %-20s %-20s \n",(contador + 1), datosTrabajadores[x][1], datosTrabajadores[x][2]);
            }
            contador++;
        }
        System.out.println("");
        System.out.println("");
        ingresoModuloGerente(codigoUsuario);
    }

    public static void agregarTrabajador(int i){
        boolean validarDNI = false, validarPuesto = false, validarBeneficio = false, validarPension = false, validarMesAnio = false, validarTienda = false;
        String nombreTrabajador, puestoTrabajador="", ingreso, beneficiosTrabajador, codigoTienda, dniTrabajador,codTrabjador,pension;
        //entradaEscaner.nextLine();
        System.out.print("Ingrese Nombre trabajador: " );
        nombreTrabajador = entradaEscaner.nextLine();

        do {
            System.out.print("Ingrese DNI trabajador: " );
            dniTrabajador = entradaEscaner.nextLine();
            if(dniTrabajador.length() == 8 && dniTrabajador.matches("[+-]?\\d*(\\.\\d+)?")){
                validarDNI = true;
            } else{
                System.out.println("*Por favor ingresar un DNI valido.");
            }

        } while (validarDNI == false);
        /*System.out.print("Ingrese DNI trabajador: " );
        dniTrabajador = entradaEscaner.nextLine();*/

        System.out.println("1.- Vendedor");
        System.out.println("2.- Gerente");
        System.out.println("3.- Administrador");
        do {
            System.out.print("Ingrese el código de cargo: " );
            puestoTrabajador = entradaEscaner.nextLine();
            if(puestoTrabajador.equals("1")|| puestoTrabajador.equals("2") || puestoTrabajador.equals("3")){
                validarPuesto = true;
            } else{
                System.out.println("*Por favor ingresar cualquier código de la lista.");
            }

        } while (validarPuesto == false);

        /*System.out.println("Indicar puesto: " );
        System.out.println("1.- Vendedor");
        System.out.println("2.- Gerente");
        System.out.println("3.- Administrador");
        puestoTrabajador = entradaEscaner.nextLine();*/

        do {
            System.out.print("Indicar si el trabajador cuenta con Asignación familiar. Responder Si o No: " );
            beneficiosTrabajador = entradaEscaner.nextLine();
            //if(beneficiosTrabajador.equals("Si")|| beneficiosTrabajador.equals("SI")|| beneficiosTrabajador.equals("si") || beneficiosTrabajador.equals("No")||beneficiosTrabajador.equals("NO")||beneficiosTrabajador.equals("no")){
            if(beneficiosTrabajador.equalsIgnoreCase("si") || beneficiosTrabajador.equalsIgnoreCase("no")){
                validarBeneficio = true;
            } else{
                System.out.println("*Por favor ingresar Si o No en el campo.");
            }

        } while (validarBeneficio == false);

        /*System.out.println("Indicar si el trabajador cuenta con Asignación familiar. Responder Si o No: ");
        beneficiosTrabajador = entradaEscaner.nextLine();*/

        System.out.println("Indicar Fondo de Pensión");
        System.out.println("1.-ONP");
        System.out.println("2.-AFP-Habitat");
        System.out.println("3.-AFP-Integra");
        System.out.println("4.-AFP-Prima");
        System.out.println("5.-AFP-Profuturo");

        do {
            System.out.print("Ingrese la pensión del trabajador: " );
            pension = entradaEscaner.nextLine();
            if(pension.equals("1")|| pension.equals("2") || pension.equals("3") || pension.equals("4") || pension.equals("5")){
                validarPension = true;
            } else{
                System.out.println("*Por favor ingresar cualquier código de la lista.");
            }

        } while (validarPension == false);

        /*pension=entradaEscaner.nextLine();*/

        do {
            System.out.print("Ingresar Fecha de Ingreso. Utilizar el siguiente formato MM/AAAA: " );
            ingreso = entradaEscaner.nextLine();
            if(ingreso.substring(0,2).matches("[+-]?\\d*(\\.\\d+)?") && ingreso.substring(3,7).matches("[+-]?\\d*(\\.\\d+)?")) {
                if ((Integer.parseInt(ingreso.substring(0,2)) >= 1 &&  Integer.parseInt(ingreso.substring(0,2)) <= 12) && (Integer.parseInt(ingreso.substring(3,7)) >= 2000 &&  Integer.parseInt(ingreso.substring(3,7)) <= 2021) && ingreso.substring(2,3).equals("/")) {
                    validarMesAnio = true;
                } else {
                    System.out.println("*Por favor ingresar una fecha existente.");
                }
            } else {
                System.out.println("*Por favor ingresar el formato establecido.");
            }
        } while (validarMesAnio == false);
        /*System.out.println("Ingresar Fecha de Ingreso. Utilizar el siguiente formato MM/AAAA");
        ingreso=entradaEscaner.nextLine();*/

        System.out.println("Los códigos de tienda actualmente son los siguientes:");
        System.out.println("Código:\tNombre\t\t\tCódigo:\tNombre\t\t\tCódigo:\tNombre" );
        System.out.println("-------\t--------\t\t-------\t--------\t\t-------\t--------");
        System.out.println("SM:\t\tSan Miguel\t\tLM:\t\tLarcomar\t\tCH:\t\tChiclayo");
        System.out.println("CC:\t\tCentro Cívico\tOG:\t\tO. Gutierrez\tHY:\t\tHuancayo");
        System.out.println("BV:\t\tBellavista\t\tAN:\t\tAngamos\t\t\tAR:\t\tArequipa");
        System.out.println("SV:\t\tSalaverry\t\tPR:\t\tPrimavera\t\tJ2:\t\tJockey II");
        System.out.println("PN:\t\tPlaza Norte\t\tEP:\t\tEl Polo\t\t\tPS:\t\tPlaza Sur");
        System.out.println("CO:\t\tComas\t\t\tST:\t\tSanta Anita\t\tMS:\t\tMall del Sur");
        System.out.println("ME:\t\tMegaplaza\t\tJ1:\t\tJockey I\t\tRA:\t\tRambla");
        System.out.println("LC:\t\tLarco\t\t\tPI:\t\tPiura");

        String[] codigosTienda = {"SM","CC","BV","SV","PN","CO","ME","LC","LM","OG","AN","PR","EP","ST","J1","PI","CH","HY","AR","J2","PS","MS","RA"};
        //validarTienda
        do {
            System.out.print("Ingresar el código de tienda: ");
            codigoTienda = entradaEscaner.nextLine();
            for (int j = 0; j < codigosTienda.length; j++) {
                if(codigosTienda[j].equals(codigoTienda)) {
                    validarTienda = true;
                }
            }
            if (validarTienda == false){
                System.out.println("*Por favor ingresar una tienda de la lista");
            }

        } while (validarTienda == false);
        /*System.out.print("Ingresar el código de tienda:");
        codigoTienda = entradaEscaner.nextLine();*/

        int cantRegistros2 = 0;
        for (int x = 0; x < datosTrabajadores.length; x++){
            if(datosTrabajadores[x][0] != null)
                cantRegistros2++;
        }

        datosTrabajadores[cantRegistros2][0] = String.valueOf(cantRegistros2+1);
        datosTrabajadores[cantRegistros2][1] = nombreTrabajador;
        datosTrabajadores[cantRegistros2][2] = dniTrabajador; //se agrega DNI de trabajador
        datosTrabajadores[cantRegistros2][3] = puestoTrabajador;
        datosTrabajadores[cantRegistros2][4] = beneficiosTrabajador;
        datosTrabajadores[cantRegistros2][5] = codigoTienda;
        codTrabjador= datosTrabajadores[cantRegistros2][5].substring(0,2)+datosTrabajadores[cantRegistros2][1].substring(0,1)+datosTrabajadores[cantRegistros2][2].substring(0,8);
        datosTrabajadores[cantRegistros2][6]= codTrabjador;
        datosTrabajadores[cantRegistros2][7]= pension;
        datosTrabajadores[cantRegistros2][8]= ingreso;
        System.out.println("");
        System.out.println("Se ha generado el código: " + datosTrabajadores[cantRegistros2][6] + " para el usuario " +datosTrabajadores[cantRegistros2][1]);
        System.out.println("");
        System.out.println("");
        ingresoModuloAdministrador(i);

    }

}