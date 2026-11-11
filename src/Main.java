public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        Libro libro1 = new Libro("BK-2024-001", "Clean Code", 2008, "Robert C. Martin", "978-0132350884");
        Libro libro2 = new Libro("BK-2024-002", "Effective Java", 2018, "Joshua Bloch", "978-0134685991");
        Revista revista1 = new Revista("RV-2024-001", "Java Magazine", 2024, 45, "Tecnología");
        Revista revista2 = new Revista("RV-2024-002", "Investigación y Ciencia", 2023, 12, "Ciencias");

        System.out.println("=== HashMap: catálogo ===");
        sistema.registrarMaterial(libro1);
        sistema.registrarMaterial(libro2);
        sistema.registrarMaterial(revista1);
        sistema.registrarMaterial(revista2);

        Material encontrado = sistema.buscarMaterial("BK-2024-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }

        Material inexistente = sistema.buscarMaterial("XX-0000-000");
        if (inexistente == null) {
            System.out.println("El código XX-0000-000 no existe en el catálogo");
        }

        System.out.println();
        System.out.println("=== ArrayList: lista de espera ===");
        libro1.setDisponible(false);
        libro1.mostrarInfo();
        sistema.agregarEspera("BK-2024-001", "Ana");
        sistema.agregarEspera("BK-2024-001", "Carlos");
        sistema.agregarEspera("BK-2024-001", "Laura");
        System.out.println("Siguiente en espera: " + sistema.siguienteEnEspera("BK-2024-001"));
        System.out.println("Siguiente en espera: " + sistema.siguienteEnEspera("BK-2024-001"));

        System.out.println();
        System.out.println("=== HashSet: membresías ===");
        System.out.println("Registrar Ana: " + sistema.registrarMiembro("Ana"));
        System.out.println("Registrar Carlos: " + sistema.registrarMiembro("Carlos"));
        System.out.println("Registrar Laura: " + sistema.registrarMiembro("Laura"));
        boolean repetido = sistema.registrarMiembro("Ana");
        System.out.println("Registrar Ana otra vez: " + repetido);
        if (!repetido) {
            System.out.println("Ana ya tiene membresía activa");
        }
        System.out.println("¿Carlos tiene membresía? " + sistema.tieneMembresia("Carlos"));
        System.out.println("¿Pedro tiene membresía? " + sistema.tieneMembresia("Pedro"));

        System.out.println();
        System.out.println("=== Polimorfismo: mostrarCatalogo() ===");
        sistema.mostrarCatalogo();
    }
}
