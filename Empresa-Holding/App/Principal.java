    package App;
    import java.io.IOException;
    import java.util.*;
    import Clases.Reclutados;
    import Clases.Vendedor;
    import Clases.Paises;
    import Clases.Empresa;
    import Clases.Area;
    import Clases.Asesor;

    public class Principal {

    static Scanner leer_s = new Scanner(System.in);
    static Scanner leer_n = new Scanner(System.in);
    static int opcionPrincipal;
    static boolean salirSistema = false;

    // Arrays utilizados
    static ArrayList<Vendedor> vendedores = new ArrayList<>();
    static ArrayList<Reclutados> reclutados = new ArrayList<>();
    static ArrayList<Asesor> asesores = new ArrayList<>();

    static ArrayList<Area> areas = new ArrayList<>();
    static ArrayList<Paises> paises = new ArrayList<>();
    static ArrayList<Empresa> empresas = new ArrayList<>();

    public static void main(String[] args) {
        /////////////////////////////////////////////////////////
        limpiarPantalla();
        System.out.println(" || VERIFICAR AUTORIZACIÓN || ");
        System.out.println("Para entrar al sistema tienes que acceder con una cuenta para saber que eres autorizad@:");
        System.out.println("");
        String usuarioGuardado = "AdrianO";
        String contraseñaGuardada = "123456";
        int intentos = 0;
        boolean autenticado = false;

        // Proceso de logueo

        while (intentos < 3 && !autenticado) {
        System.out.print("Digite el usuario: ");
        String usuario = leer_s.nextLine();

        System.out.print("Digite la contraseña: ");
        String contraseña = leer_s.nextLine();

        if (usuario.equals(usuarioGuardado) && contraseña.equals(contraseñaGuardada)) {
        autenticado = true;
        System.out.println("Credenciales correctas. ¡Bienvenido!");
        pausarPantalla();
        } else {
        intentos++;
        System.out.println("Usuario o contraseña incorrectos. Te quedan " + (3 - intentos) + " intentos.");
        System.out.println("");
        }
        }

        if (!autenticado) {
            System.out.println("Demasiados intentos fallidos.");
            return;
        }

        // Añadir países pre-definidos al sistema.
        paises.add(new Paises("Colombia", 0.19, 52000000L, "Bogotá D.C"));
        paises.add(new Paises("Argentina", 3.9, 45892285L, "Buenos Aires"));

        // Añadir empresas pre-definidas al sistema.
        Date fechaMakro = new Date();
        empresas.add(new Empresa("Makro", fechaMakro, 52000000, 34, new ArrayList<>(Arrays.asList("Colombia")),
        new ArrayList<>(Arrays.asList("Ejecutivos")), new ArrayList<>(Arrays.asList("Cartagena")),
        new ArrayList<>(Arrays.asList("Ventas")), new ArrayList<>(Arrays.asList("Alberto"))));

        Date fechaD1 = new Date();
        empresas.add(new Empresa("D1", fechaD1, 55000000, 35, new ArrayList<>(Arrays.asList("Colombia, Argentina")),
        new ArrayList<>(Arrays.asList("Olaya")), new ArrayList<>(Arrays.asList("Cartagena")),
        new ArrayList<>(Arrays.asList("Ventas")), new ArrayList<>(Arrays.asList("Alberto"))));

        // Añadir áreas pre-definidas al sistema.
        areas.add(new Area("Ventas", "Manejo del patrimonio."));
        areas.add(new Area("Marketing", "Publicidad de la empresa en general."));
        areas.add(new Area("Produccion", "Crear más materia prima."));

        int opcionPrincipal;
        boolean salirSistema = false;

        do {
            limpiarPantalla();
            System.out.println("Bienvenido, estas son las opciones disponibles:");
            System.out.println("1. Apartado de Vendedores");
            System.out.println("2. Apartado de Empresas.");
            System.out.println("3. Apartado de Paises.");
            System.out.println("4. Apartado de Asesores");
            System.out.println("5. Salir del sistema.");
            System.out.print("Digite una opción: ");

            do {
                while (!leer_n.hasNextInt()) {
                    System.out.println("⚠ Digite un número válido.");
                    leer_n.next();
                }
                opcionPrincipal = leer_n.nextInt();

                if (opcionPrincipal < 0 || opcionPrincipal > 5) {
                    System.out.println("⚠ La opción es inválida.");
                }
            } while (opcionPrincipal < 0 || opcionPrincipal > 5);

            switch (opcionPrincipal) {
                case 1:
                    menuVendedores();
                    pausarPantalla();
                    break;
                case 2:
                    menuEmpresas();
                    break;
                case 3:
                    menuPaises();
                    pausarPantalla();
                    break;
                case 4:
                    menuAsesor();
                    pausarPantalla();
                    break;
                case 5:
                    salirSistema = true;
                    break;
            }

        } while (!salirSistema);

        limpiarPantalla();
        System.out.println(" ¡Gracias por usar el sistema!");
    }

    //Métodos relacionados con la pantalla
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pausarPantalla() {
        System.out.println("\t\n Presione enter para continuar");
        leer_s.nextLine();
    }

    //Métodos de validación
    public static boolean contieneNumeros(String facts) {
        return facts.matches(".*\\d.*");
    }

    //Apartado de vendedores
    public static void menuVendedores() {
        boolean salirVendedores = false;
        int opcionVendedores;

        do {
            limpiarPantalla();
            System.out.println(" -> || VENDEDORES || <- ");
            System.out.println("");
            System.out.println("¡Ingresaste al apartado de vendedores!");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Añadir vendedor.");
            System.out.println("2. Reclutar más vendedores (Sólo jerarquía)");
            System.out.println("3. Ver vendedores.");
            System.out.println("4. Ver los vendedores reclutados por otro vendedor.");
            System.out.println("5. Volver al menú principal.");
            System.out.print("Digite una opción: ");

            do {
                while (!leer_n.hasNextInt()) {
                    System.out.println("Digite un número, no un cáracter.");
                    leer_n.next();
                }
                opcionVendedores = leer_n.nextInt();

                if (opcionVendedores < 0 || opcionVendedores > 5) {
                    System.out.println("La opción es inválida.");
                }
            } while (opcionVendedores < 0 || opcionVendedores > 5);

            switch (opcionVendedores) {

                case 1:
                    añadirVendedor(vendedores, empresas);
                    pausarPantalla();
                    break;

                case 2:
                    reclutarVendedores(reclutados, vendedores);
                    pausarPantalla();
                    break;

                case 3:
                    verVendedores(vendedores);
                    pausarPantalla();
                    break;

                case 4:
                    verVendedoresReclutadoPorOtroVendedor(reclutados);
                    pausarPantalla();
                    break;

            }

            if (opcionVendedores == 5) {
                salirVendedores = true;
            }

        } while (!salirVendedores);
    }

    public static void añadirVendedor(ArrayList<Vendedor> vendedores, ArrayList<Empresa> empresas) {
        limpiarPantalla();
        String codigo, nombre, direccion;
        Date fechaRegistro = new Date();
        boolean rango;
        String empresa;
        int numeroVentas;
        double volumenFacturacion;

        System.out.println("-> || REGISTRAR VENDEDOR || <-");
        System.out.println("");

        do {
            System.out.print("1. Digite el nombre del vendedor: ");
            nombre = leer_s.nextLine();

            if (contieneNumeros(nombre)) {
                System.out.println("El nombre no puede contener números.");
                System.out.println("");
            }

            if (nombre.length() < 3) {
                System.out.println("El nombre es demasiado corto.");
                System.out.println("");
            }
        } while (nombre.length() < 3 || contieneNumeros(nombre));

        do {
            System.out.print("2. Digite el código del vendedor: ");
            codigo = leer_s.nextLine();

            if (codigo.length() < 6) {
                System.out.println("El código es demasiado corto.");
                System.out.println("");
            }
        } while (codigo.length() < 6);

        // Verificación que no exista un cliente con mismo código
        boolean existe = false;
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getCodigo().equals(codigo)) {
                existe = true;
            }
        }
        if (!existe) {

            do {
                System.out.print("3. Digite la dirección  del vendedor: ");
                direccion = leer_s.nextLine();

                if (direccion.length() < 6) {
                    System.out.println("La dirección es demasiado corta.");
                    System.out.println("");
                }
            } while (direccion.length() < 6);

            int opcionJerarquia;
            System.out.println("¿4. El vendedor cuenta con el rango para reclutar más vendedores?");
            System.out.println("1. Sí tiene jerarquía.");
            System.out.println("2. No tiene jerarquía.");
            System.out.print("Digite una opción: ");
            do {
                while (!leer_n.hasNextInt()) {
                    System.out.println("Digite un número, no un cáracter.");
                    leer_n.next();
                }
                opcionJerarquia = leer_n.nextInt();

                if (opcionJerarquia < 1 || opcionJerarquia > 2) {
                    System.out.println("La opción es inválida.");
                }
            } while (opcionJerarquia < 1 || opcionJerarquia > 2);

            switch (opcionJerarquia) {

                case 1:
                    rango = true;

                    // Asignar empresa
                    do {
                        System.out.print("5. Introduce el nombre de la empresa: ");
                        empresa = leer_s.nextLine();

                        if (empresa.length() < 5) {
                            System.out.println("El nombre de la empresa es muy corta.");
                        }

                    } while (empresa.length() < 5);

                    // Validar que la empresa exista
                    boolean existeEmpresa = false;

                    for (int i = 0; i < empresas.size(); i++) {
                        if (empresas.get(i).getNombre().equalsIgnoreCase(empresa)) {
                            existeEmpresa = true;
                        }
                    }

                    if (!existeEmpresa) {
                        limpiarPantalla();
                        System.out.println("|| ERROR DE BÚSQUEDA ||");
                        System.out.println("La empresa digitada no se encuentra en el sistema.");
                    } else {

                        do {
                            System.out.print("6. Introduce el número del ventas del vendedor: ");
                            while (!leer_n.hasNextInt()) {
                                System.out.println("Introduce un número, no un cáracter.");
                                leer_n.next();
                            }
                            numeroVentas = leer_n.nextInt();

                            if (numeroVentas < 0) {
                                System.out.println("Las ventas no pueden ser negativas.");
                            }
                        } while (numeroVentas < 0);

                        do {
                            System.out.print("7. Introduce el volumen de facturación del vendedor: ");
                            while (!leer_n.hasNextDouble()) {
                                System.out.println("Introduce un número, no un cáracter.");
                                leer_n.next();
                            }
                            volumenFacturacion = leer_n.nextInt();

                            if (volumenFacturacion < 0) {
                                System.out.println("El volumen de facturación no puede ser negativos.");
                            }
                        } while (volumenFacturacion < 0);

                        System.out.println("El vendedor fue registrado con éxito");
                        vendedores.add(new Vendedor(fechaRegistro, codigo, nombre, direccion, rango, empresa,
                                numeroVentas, volumenFacturacion));
                        break;
                    }

                case 2:
                    rango = true;
                    System.out.println("Por último, ingresa la empresa donde está asignado " + nombre + ": ");

                    // Asignar empresa
                    do {
                        System.out.print("5. Introduce el nombre de la empresa: ");
                        empresa = leer_s.nextLine();

                        if (empresa.length() < 5) {
                            System.out.println("El nombre de la empresa es muy corta.");
                        }

                    } while (empresa.length() < 5);

                    // Validar que la empresa exista
                    boolean existeEmpresa2 = false;

                    for (int i = 0; i < empresas.size(); i++) {
                        if (empresas.get(i).getNombre().equalsIgnoreCase(empresa)) {
                            existeEmpresa2 = true;
                        }
                    }

                    if (!existeEmpresa2) {
                        limpiarPantalla();
                        System.out.println("ERROR DE BÚSQUEDA");
                        System.out.println("La empresa digitada no se encuentra en el sistema.");
                    } else {

                        do {
                            System.out.print("6. Introduce el número del ventas del vendedor: ");
                            while (!leer_n.hasNextInt()) {
                                System.out.println("Introduce un número, no un cáracter.");
                                leer_n.next();
                            }
                            numeroVentas = leer_n.nextInt();

                            if (numeroVentas < 0) {
                                System.out.println("Las ventas no pueden ser negativas.");
                            }
                        } while (numeroVentas < 0);

                        do {
                            System.out.print("7. Introduce el volumen de facturación del vendedor: ");
                            while (!leer_n.hasNextDouble()) {
                                System.out.println("Introduce un número, no un cáracter.");
                                leer_n.next();
                            }
                            volumenFacturacion = leer_n.nextInt();

                            if (volumenFacturacion < 0) {
                                System.out.println("El volumen de facturación no puede ser negativos.");
                            }
                        } while (volumenFacturacion < 0);
                        limpiarPantalla();
                        System.out.println("El vendedor fue registrado con éxito");
                        vendedores.add(new Vendedor(fechaRegistro, codigo, nombre, direccion, rango, empresa,
                                numeroVentas, volumenFacturacion));
                        break;
                    }
            }
        } else {
            limpiarPantalla();
            System.out.println(" || ERROR 405 ||");
            System.out.println("Ya existe un cliente registrado con ese código.");
        }
    }

    public static void verVendedores(ArrayList<Vendedor> vendedores) {
        limpiarPantalla();
        System.out.println(" || LISTA DE VENDEDORES REGISTRADOS EN EL SISTEMA || ");
        System.out.println("");
        for (Vendedor i : vendedores) {
            System.out.println(i);
            System.out.println("");
        }
    }

    public static void verVendedoresReclutadoPorOtroVendedor(ArrayList<Reclutados> reclutados) {
        limpiarPantalla();
        System.out.println(" || LISTA DE VENDEDORES REGISTRADOS EN EL SISTEMA || ");
        System.out.println("Nota: agregados por otros vendedores.");
        System.out.println("");
        for (Reclutados i : reclutados) {
            System.out.println(i);
            System.out.println("");
        }
    }

    public static void reclutarVendedores(ArrayList<Reclutados> reclutados, ArrayList<Vendedor> vendedores) {
        limpiarPantalla();
        String verificarCodigo, verificarNombre;
        String empresaReclutador;

        System.out.println(" -> || RECLUTAR MÁS VENDEDORES || <- ");
        System.out.println("");
        System.out.println("* Sólo se puede reclutar vendedores si eres un vendedor con jerarquía.");
        System.out.println("");

        // Si no hay vendedores, muestra el mensaje y regresa
        if (reclutados.isEmpty() && vendedores.isEmpty()) {
            System.out.println("No hay vendedores registrados en el sistema.");
            return;
        }

        do {
            System.out.print("1. Digita tu nombre: ");
            verificarNombre = leer_s.nextLine();

            if (contieneNumeros(verificarNombre)) {
                System.out.println("El nombre no puede contener números.");
                System.out.println("");
            }

            if (verificarNombre.length() < 3) {
                System.out.println("El nombre es demasiado corto.");
                System.out.println("");
            }
        } while (verificarNombre.length() < 3 || contieneNumeros(verificarNombre));

        do {
            System.out.print("2. Digita tu código para hallarte en el sistema: ");
            verificarCodigo = leer_s.nextLine();

            if (verificarCodigo.length() < 6) {
                System.out.println("El código es demasiado corto.");
                System.out.println("");
            }
        } while (verificarCodigo.length() < 6);

        // Bandera para rastrear si encontramos al vendedor
        boolean vendedorEncontrado = false;

        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getNombre().trim().equals(verificarNombre) &&
                    vendedores.get(i).getCodigo().trim().equals(verificarCodigo)) {

                // Añadimos la empresa default
                empresaReclutador = vendedores.get(i).getEmpresa();

                limpiarPantalla();
                System.out.println("Fuiste hallado en el sistema, estos son tus datos:");
                System.out.println("");
                System.out.println(vendedores.get(i));
                System.out.println("");
                pausarPantalla();

                if (vendedores.get(i).getRango()) {
                    limpiarPantalla();
                    int opcionParaReclutar;

                    System.out
                            .println(vendedores.get(i).getNombre() + " tienes jerarquía para reclutar más vendedores.");
                    System.out.println("");
                    System.out.println("¿Deseas reclutar otro/a vendedor/a?");
                    System.out.println("1. Sí.");
                    System.out.println("2. No.");
                    System.out.print("Digita una opción: ");
                    do {
                        while (!leer_n.hasNextInt()) {
                            System.out.println("Digite un número, no un cáracter.");
                            leer_s.next();
                        }

                        opcionParaReclutar = leer_n.nextInt();

                        if (opcionParaReclutar < 0 || opcionParaReclutar > 2) {
                            System.out.println("Opción inválida.");
                        }

                    } while (opcionParaReclutar < 0 || opcionParaReclutar > 2);

                    switch (opcionParaReclutar) {

                        case 1:
                            limpiarPantalla();
                            System.out.println(vendedores.get(i).getNombre()
                                    + ". Harás el proceso de inscripción para otro vendedor:");

                            // Proceso de inscripción
                            String codigo, nombre, direccion;
                            Date fechaRegistro = new Date();
                            boolean rango;
                            int numeroVentas;
                            double volumenFacturacion;

                            System.out.println("-> || REGISTRAR VENDEDOR || <-");
                            System.out.println("");

                            do {
                                System.out.print("1. Digite el nombre del vendedor: ");
                                nombre = leer_s.nextLine();

                                if (contieneNumeros(nombre)) {
                                    System.out.println("El nombre no puede contener números.");
                                    System.out.println("");
                                }

                                if (nombre.length() < 3) {
                                    System.out.println("El nombre es demasiado corto.");
                                    System.out.println("");
                                }
                            } while (nombre.length() < 3 || contieneNumeros(nombre));

                            do {
                                System.out.print("2. Digite el código del vendedor: ");
                                codigo = leer_s.nextLine();

                                if (codigo.length() < 6) {
                                    System.out.println("El código es demasiado corto.");
                                    System.out.println("");
                                }
                            } while (codigo.length() < 6);

                            // Verificación que no exista un cliente con mismo código
                            boolean existe = false;
                            for (int j = 0; j < vendedores.size(); j++) {
                                for (int r = 0; r < reclutados.size(); r++) {
                                    if (vendedores.get(i).getCodigo().equals(codigo)
                                            || reclutados.get(i).getCodigo().equals(codigo)) {
                                        existe = true;
                                    }
                                }
                            }

                            if (!existe) {

                                do {
                                    System.out.print("3. Digite la dirección  del vendedor: ");
                                    direccion = leer_s.nextLine();

                                    if (direccion.length() < 6) {
                                        System.out.println("La dirección es demasiado corta.");
                                        System.out.println("");
                                    }
                                } while (direccion.length() < 6);

                                int opcionJerarquia;
                                System.out.println("¿4. El vendedor cuenta con el rango para reclutar más vendedores?");
                                System.out.println("1. Sí tiene jerarquía.");
                                System.out.println("2. No tiene jerarquía.");
                                System.out.print("Digite una opción: ");
                                do {
                                    while (!leer_n.hasNextInt()) {
                                        System.out.println("Digite un número, no un cáracter.");
                                        leer_n.next();
                                    }
                                    opcionJerarquia = leer_n.nextInt();

                                    if (opcionJerarquia < 0 || opcionJerarquia > 2) {
                                        System.out.println("La opción es inválida.");
                                    }
                                } while (opcionJerarquia < 0 || opcionJerarquia > 3);

                                // Asignamos automáticamente la empresa
                                System.out.println("El vendedor será asignado a la empresa " + empresaReclutador);

                                switch (opcionJerarquia) {

                                    case 1:
                                        rango = true;
                                        do {
                                            System.out.print("5. Introduce el número del ventas del vendedor: ");
                                            while (!leer_n.hasNextInt()) {
                                                System.out.println("Introduce un número, no un cáracter.");
                                                leer_n.next();
                                            }
                                            numeroVentas = leer_n.nextInt();

                                            if (numeroVentas < 0) {
                                                System.out.println("Las ventas no pueden ser negativas.");
                                            }
                                        } while (numeroVentas < 0);

                                        do {
                                            System.out.print("6. Introduce el volumen de facturación del vendedor: ");
                                            while (!leer_n.hasNextDouble()) {
                                                System.out.println("Introduce un número, no un cáracter.");
                                                leer_n.next();
                                            }
                                            volumenFacturacion = leer_n.nextInt();

                                            if (volumenFacturacion < 0) {
                                                System.out.println("El volumen de facturación no puede ser negativos.");
                                            }
                                        } while (volumenFacturacion < 0);
                                        limpiarPantalla();
                                        reclutados.add(new Reclutados(fechaRegistro, codigo, nombre, direccion, rango,
                                                empresaReclutador, numeroVentas, volumenFacturacion));
                                        System.out.println("El vendedor fue registrado con éxito");
                                        break;

                                    case 2:
                                        rango = false;
                                        do {
                                            System.out.print("5. Introduce el número del ventas del vendedor: ");
                                            while (!leer_n.hasNextInt()) {
                                                System.out.println("Introduce un número, no un cáracter.");
                                                leer_n.next();
                                            }
                                            numeroVentas = leer_n.nextInt();

                                            if (numeroVentas < 0) {
                                                System.out.println("Las ventas no pueden ser negativas.");
                                            }
                                        } while (numeroVentas < 0);

                                        do {
                                            System.out.print("6. Introduce el volumen de facturación del vendedor: ");
                                            while (!leer_n.hasNextDouble()) {
                                                System.out.println("Introduce un número, no un cáracter.");
                                                leer_n.next();
                                            }
                                            volumenFacturacion = leer_n.nextInt();

                                            if (volumenFacturacion < 0) {
                                                System.out.println("El volumen de facturación no puede ser negativos.");
                                            }
                                        } while (volumenFacturacion < 0);
                                        limpiarPantalla();
                                        reclutados.add(new Reclutados(fechaRegistro, codigo, nombre, direccion, rango,
                                                empresaReclutador, numeroVentas, volumenFacturacion));
                                        System.out.println("El vendedor fue registrado con éxito");
                                        break;
                                }

                            } else {
                                limpiarPantalla();
                                System.out.println(" || ERROR 405 ||");
                                System.out.println("Ya existe un cliente registrado con un código.");
                            }
                            // break caso 1
                            break;

                        case 2:
                            limpiarPantalla();
                            System.out.println("|| OPERACIÓN CANCELADA ||");
                            System.out.println("Cancelaste el proceso de añadir otro vendedor.");
                            break;
                    }

                } else {
                    limpiarPantalla();
                    System.out.println(" || ERROR DE JERARQUÍA || ");
                    System.out.println(
                            "Fuiste hallado en el sistema pero no tienes derecho para reclutar más vendedores.");
                }

                vendedorEncontrado = true;
                break; // Detiene el bucle una vez que encontramos al vendedor
            }
        }

        if (!vendedorEncontrado) {
            limpiarPantalla();
            System.out.println("|| ERROR 404 ||");
            System.out.println("No se encontró ningún vendedor con ese nombre y código.");
        }
    }

    //Apartado de empresas
    public static void menuEmpresas() {
        int opcionEmpresa;
        boolean salirEmpresa = false;

        do {
            limpiarPantalla();
            System.out.println(" -> || EMPRESAS || <- ");
            System.out.println("");
            System.out.println("¡Ingresaste al apartado de empresas!");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Registrar una empresa.");
            System.out.println("2. Ver informes periódicos de la empresa.");
            System.out.println("3. Volver al menú principal.");
            System.out.print("Digite una opción: ");

            do {
                while (!leer_n.hasNextInt()) {
                    System.out.println("Digite un número, no un cáracter.");
                    leer_n.next();
                }
                opcionEmpresa = leer_n.nextInt();

                if (opcionEmpresa < 0 || opcionEmpresa > 3) {
                    System.out.println("La opción es inválida.");
                }
            } while (opcionEmpresa < 0 || opcionEmpresa > 3);

            switch (opcionEmpresa) {

                case 1:
                    añadirEmpresas(empresas, paises, areas, asesores);
                    pausarPantalla();
                    break;

                case 2:
                    informesEmpresas(empresas);
                    pausarPantalla();
                    break;

            }

            if (opcionEmpresa == 3) {
                salirEmpresa = true;
            }
        } while (!salirEmpresa);
    }

    public static void añadirEmpresas(ArrayList<Empresa> empresas, ArrayList<Paises> paises, ArrayList<Area> areas,
            ArrayList<Asesor> asesores) {
        limpiarPantalla();
        String nombre;
        Date fechaIncorporacion;
        double facturacionAnual;
        int numeroVendedoresEmpleados;
        ArrayList<String> paisesDondeOpera = new ArrayList<>();
        ArrayList<String> sedeDondeOpera = new ArrayList<>();
        ArrayList<String> ciudadDeLaSede = new ArrayList<>();
        ArrayList<String> areasDeMercado = new ArrayList<>();
        ArrayList<String> asesoresOperantes = new ArrayList<>();

        // Nombre de la empresa
        do {
            System.out.print("1. Introduce el nombre de la empresa: ");
            nombre = leer_s.nextLine().trim();

            if (nombre.length() < 5) {
                System.out.println("El nombre de la empresa es muy corto.");
            }
        } while (nombre.length() < 5);

        // Facturación anual
        do {
            System.out.print("2. Digite la facturación anual de la empresa " + nombre + ": ");
            while (!leer_n.hasNextDouble()) {
                System.out.println("Introduce un número válido.");
                leer_n.next();
            }
            facturacionAnual = leer_n.nextDouble();
            leer_n.nextLine(); // Consumir salto de línea

            if (facturacionAnual < 0) {
                System.out.println("No se aceptan valores negativos.");
            }
        } while (facturacionAnual < 0);

        // Número de empleados
        do {
            System.out.print("3. Digite el número de empleados de la empresa " + nombre + ": ");
            while (!leer_n.hasNextInt()) {
                System.out.println("Introduce un número válido.");
                leer_n.next();
            }
            numeroVendedoresEmpleados = leer_n.nextInt();
            leer_n.nextLine(); // Consumir salto de línea

            if (numeroVendedoresEmpleados < 0) {
                System.out.println("No se aceptan valores negativos.");
            }
        } while (numeroVendedoresEmpleados < 0);

        // Áreas de mercado
        System.out.println("4. Introduce las áreas de mercado (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("-> ");
            String area = leer_s.nextLine().trim();

            if (area.equalsIgnoreCase("fin"))
                break;

            boolean existeArea = areas.stream().anyMatch(a -> a.getNombre().equalsIgnoreCase(area));

            if (!existeArea) {
                System.out.println(" || ERROR || El área no existe.");
            } else {
                areasDeMercado.add(area);
            }
        }

        // Países donde opera
        System.out.println("5. Introduce los países donde opera la empresa (escribe 'fin' para terminar):");
        while (true) {
            System.out.print(" -> ");
            String pais = leer_s.nextLine().trim();

            if (pais.equalsIgnoreCase("fin"))
                break;

            boolean existePais = paises.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(pais));

            if (!existePais) {
                System.out.println(" || ERROR || El país no está registrado.");
            } else {
                paisesDondeOpera.add(pais);
            }
        }

        // Sedes de la empresa
        System.out.println("6. Introduce las sedes donde opera la empresa (escribe 'fin' para terminar): ");
        while (true) {
            System.out.print(" -> ");
            String sede = leer_s.nextLine().trim();

            if (sede.equalsIgnoreCase("fin"))
                break;
            sedeDondeOpera.add(sede);
        }

        // Ciudades de las sedes
        System.out.println("7. Introduce las ciudades de las sedes (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("-> ");
            String ciudad = leer_s.nextLine().trim();

            if (ciudad.equalsIgnoreCase("fin"))
                break;
            ciudadDeLaSede.add(ciudad);
        }

        limpiarPantalla();

        // Fecha de incorporación
        fechaIncorporacion = new Date();

        // Agregar asesores
        System.out.println("8. Digite los asesores de la empresa " + nombre + " (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("-> ");
            String asesor = leer_s.nextLine().trim();

            if (asesor.equalsIgnoreCase("fin"))
                break;

            boolean existeAsesor = asesores.stream().anyMatch(a -> a.getNombre().equalsIgnoreCase(asesor));

            if (!existeAsesor) {
                System.out.println(" || ERROR || El asesor no existe.");
            } else {
                asesoresOperantes.add(asesor);
            }
        }

        // Agregar empresa a la lista
        empresas.add(new Empresa(nombre, fechaIncorporacion, facturacionAnual, numeroVendedoresEmpleados,
                paisesDondeOpera, sedeDondeOpera, ciudadDeLaSede, areasDeMercado, asesoresOperantes));

        System.out.println("La empresa ha sido añadida con éxito.");

    }

    public static void informesEmpresas(ArrayList<Empresa> empresas) {
        limpiarPantalla();
        System.out.println("|| INFORMES PERIÓDICOS || ");
        System.out.println("");
        for (Empresa i : empresas) {
            System.out.println(i);
        }
    }

    //Apartado de paises
    public static void menuPaises() {
        int opcionPaises;
        boolean salirPaises = false;

        do {
            limpiarPantalla();
            System.out.println(" -> || PAISES || <- ");
            System.out.println("");
            System.out.println("¡Ingresaste al apartado de países!");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Añadir un estilo de País.");
            System.out.println("2. Volver al menú principal.");
            System.out.print("Digite una opción: ");

            do {
                while (!leer_n.hasNextInt()) {
                    System.out.println("Digite un número, no un cáracter.");
                    leer_n.next();
                }
                opcionPaises = leer_n.nextInt();

                if (opcionPaises < 0 || opcionPaises > 2) {
                    System.out.println("La opción es inválida.");
                }
            } while (opcionPaises < 0 || opcionPaises > 2);

            switch (opcionPaises) {

                case 1:
                    añadirPaises(paises);
                    pausarPantalla();
                    break;
            }

            if (opcionPaises == 2) {
                salirPaises = true;
            }
        } while (!salirPaises);

    }

    public static void añadirPaises(ArrayList<Paises> paises) {
        limpiarPantalla();
        String nombre, capital;
        double PIB;
        Long poblacion;

        do {
            System.out.print("1. Introduce el nombre del país: ");
            nombre = leer_s.nextLine();

            if (nombre.length() < 4) {
                System.out.println("El nombre del país es demasiado corto.");
                System.out.println("");
            }

            if (contieneNumeros(nombre)) {
                System.out.println("El nombre del país no puede contener números.");
                System.out.println("");
            }
        } while (contieneNumeros(nombre) || nombre.length() < 4);

        do {
            System.out.print("2. Introduce la capital del país: ");
            capital = leer_s.nextLine();

            if (capital.length() < 4) {
                System.out.println("La capital del país es demasiado corto.");
                System.out.println("");
            }

            if (contieneNumeros(capital)) {
                System.out.println("La capital del país no puede contener números.");
                System.out.println("");
            }
        } while (contieneNumeros(capital) || capital.length() < 4);

        // PIB

        do {
            System.out.print("3. Introduce el PIB del país:");
            while (!leer_n.hasNextDouble()) {
                System.out.println("Introduce un número, no un cáracter.");
                leer_n.next();
            }
            PIB = leer_n.nextDouble();

            if (PIB < 0) {
                System.out.println("El PIB no puede ser negativo.");
            }
        } while (PIB < 0);

        do {
            System.out.print("3. Introduce la población del país: ");
            while (!leer_n.hasNextLong()) {
                System.out.println("Introduce un número, no carácteres.");
                leer_n.next();
            }
            poblacion = leer_n.nextLong();
            leer_n.nextLine();

            if (poblacion < 0) {
                System.out.println("La población no puede ser negativa.");
            }
        } while (poblacion < 0);
        limpiarPantalla();
        paises.add(new Paises(nombre, PIB, poblacion, capital));
        System.out.println("El modelo del país ha sido añadido con éxito.");

    }

    //Apartado de Asesor
    public static void menuAsesor() {
        int opcionAsesor;
        boolean salirAsesor = false;

        do {
            limpiarPantalla();
            System.out.println(" -> || ASESOR || <- ");
            System.out.println("");
            System.out.println("¡Ingresaste al apartado de asesor!");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Añadir un asesor.");
            System.out.println("2. Volver al menú principal.");
            System.out.print("Digite una opción: ");

        do {
        while (!leer_n.hasNextInt()) {
        System.out.println("Digite un número, no un cáracter.");
        leer_n.next();
        }
        opcionAsesor = leer_n.nextInt();

        if (opcionAsesor < 0 || opcionAsesor > 2) {
        System.out.println("La opción es inválida.");
        }
        }while(opcionAsesor < 0 || opcionAsesor > 2);

        switch(opcionAsesor) {

        case 1:
        añadirAsesor(asesores, empresas);
        pausarPantalla();
        break;
        }

        if (opcionAsesor == 2) {
        salirAsesor = true;
        }
        } while (!salirAsesor);
    }

    public static void añadirAsesor(ArrayList<Asesor> asesores, ArrayList<Empresa> empresas) {

        limpiarPantalla();
        String codigo, nombre, direccion, titulacion;
        ArrayList<String> areasOperadas = new ArrayList<>();
        ArrayList<String> empresasOperadas = new ArrayList<>();
        ArrayList<Date> fechaContratacion = new ArrayList<>();

        // Código del asesor
        do {
            System.out.print("1. Digite el código: ");
            codigo = leer_s.nextLine();

            if (codigo.length() < 6) {
                System.out.println("El código es demasiado corto.");
            }
        } while (codigo.length() < 6);

        // Nombre del asesor
        do {
            System.out.print("2. Digite el nombre: ");
            nombre = leer_s.nextLine();

            if (nombre.length() < 3) {
                System.out.println("El nombre es demasiado corto.");
            }
        } while (nombre.length() < 3);

        // Validar que no exista ese código
        boolean existeCodigo = false;
        for (Asesor asesor : asesores) {
            if (asesor.getCodigo().equals(codigo)) {
                existeCodigo = true;
                break;
            }
        }

        if (!existeCodigo) {
            // Dirección
            do {
                System.out.print("3. Digite la dirección de " + nombre + ": ");
                direccion = leer_s.nextLine();

                if (direccion.length() < 5) {
                    System.out.println("La dirección es demasiado corta.");
                }
            } while (direccion.length() < 5);

            // Titulación
            do {
                System.out.print("4. Introduce la titulación de " + nombre + ": ");
                titulacion = leer_s.nextLine();

                if (contieneNumeros(titulacion)) {
                    System.out.println("La titulación no puede contener números.");
                }
                if (titulacion.length() < 3) {
                    System.out.println("El nombre de la titulación es demasiado corto.");
                }
            } while (titulacion.length() < 3 || contieneNumeros(titulacion));

            // Áreas de mercado
            System.out.println("5. Introduce las áreas de mercado (escribe 'fin' para terminar):");
            while (true) {
                System.out.print("-> ");
                String area = leer_s.nextLine();

                if (area.equalsIgnoreCase("fin"))
                    break;

                boolean existeArea = areas.stream().anyMatch(a -> a.getNombre().equals(area));

                if (!existeArea) {
                    limpiarPantalla();
                    System.out.println(" || ERROR - ÁREA NO REGISTRADA || ");
                } else {
                    areasOperadas.add(area);
                }
            }

            // Empresas asesoradas
            System.out.println("6. ¿Cuáles empresas estás asesorando? (escribe 'fin' para terminar):");
            while (true) {
                System.out.print("-> ");
                String empresa = leer_s.nextLine();

                if (empresa.equalsIgnoreCase("fin"))
                    break;

                boolean existeEmpresa = empresas.stream().anyMatch(e -> e.getNombre().equalsIgnoreCase(empresa));

                if (!existeEmpresa) {
                    limpiarPantalla();
                    System.out.println("|| ERROR - EMPRESA NO REGISTRADA ||");
                } else {
                    empresasOperadas.add(empresa);
                    fechaContratacion.add(new Date()); // Se registra la fecha de contratación
                }
            }

            // Agregar asesor
            limpiarPantalla();
            asesores.add(new Asesor(codigo, nombre, titulacion, direccion, areasOperadas, empresasOperadas,
                    fechaContratacion));
            System.out.println("Asesor registrado con éxito!");
        } else {
            limpiarPantalla();
            System.out.println(" || ERROR - CÓDIGO REPETIDO || ");
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}