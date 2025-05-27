
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Leer el archivo de entrada
        String input = new String(Files.readAllBytes(Paths.get("./tests/test6.txt")));
        CharStream charStream = CharStreams.fromString(input);

        // Crear el lexer y parser
        ExprLexer lexer = new ExprLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        // Verificar si hubo errores de sintaxis
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Errores de sintaxis encontrados.");
            return;
        } 
        // Parsear el archivo
        ParseTree tree = parser.all();
        SemanticVisitor visitor = new SemanticVisitor();
        //System.out.println("tree = " + tree.toStringTree(parser));

        visitor.visit(tree);
                
        // Imprimir las variables detectadas
        System.out.println("Tabla: \n" + visitor.imprimirDirectorio());
        // Imprimir los cuádruplos generados
        visitor.imprimirCuadruplos();
        visitor.imprimirMemoriaVirtual();
    }
}
