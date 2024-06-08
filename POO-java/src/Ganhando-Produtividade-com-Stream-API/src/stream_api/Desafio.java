package stream_api;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Desafio {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3 );

        System.out.println("Desafio 1 - Mostre a lista na ordem numérica: ");
        numeros.stream().sorted().forEach(s -> System.out.print(s + " "));

        System.out.println("\n\nDesafio 2 - Imprima a soma dos números pares da lista: ");
        //int somaPares = numeros.stream().filter(n -> n % 2 == 0).reduce(0, (n1, n2) -> n1 + n2);
        int somaPares = numeros.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
        System.out.println(somaPares);

        System.out.println("\nDesafio 3 - Verifique se todos os números da lista são positivos: ");
        System.out.println(numeros.stream().allMatch(n -> n >= 0));

        System.out.println("\nDesafio 4 - Remova todos os valores ímpares: ");
        List<Integer> removendoImpares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(removendoImpares);


        System.out.println("\nDesafio 5 - Calcule a média dos números maiores que 5: ");
        /* double media = numeros.stream().filter(n -> n > 5)
         *       .mapToDouble(Integer::doubleValue)
         *       .average()
         *       .getAsDouble();
         * */
         double media = numeros.stream().filter(n -> n > 5)
               .mapToDouble(Integer::doubleValue)
               .average()
               .orElseThrow(() -> new NoSuchElementException("Não foi possível encontrar a média."));
        System.out.println(media);

        System.out.println("\nDesafio 6 - Verificar se a lista contém algum número maior que 10: ");
        System.out.println(numeros.stream().anyMatch(n -> n > 10));

        System.out.println("\nDesafio 7 - Encontrar o segundo número maior da lista: ");
        System.out.println(numeros.stream().distinct()
                .sorted(Comparator
                .reverseOrder())
                .skip(1)
                .findFirst()
                //.orElse(null);
                .orElseThrow(() -> new NoSuchElementException("Não existe segundo maior número.")));

        /* OUTRA FORMA DE FAZER
            List<Integer> numerosOrdenados = numeros.stream()
                .sorted()
                .distinct()
                .toList();

            int segundoMaisAlto = numerosOrdenados.get(numerosOrdenados.size() - 2);
         */

        System.out.println("\nDesafio 8 - Somar os dígitos de todos os números da lista: ");
        long somaDigitos = numeros.stream().mapToInt(n1 -> {
            int sum = 0, length = String.valueOf(n1).length();
            for (int i = 0; i < length; i++) {
                sum += n1 % 10;
                n1 /= 10;
            }
            return sum;
        }).sum();
        System.out.println(somaDigitos);

        System.out.println("\nDesafio 9 - Verificar se todos os números da lista são distintos (não se repetem): ");
        long repetido = numeros.stream().distinct().count();
        System.out.println(numeros.size() == repetido);

        System.out.println("\nDesafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5: ");
       /* List<Integer> numerosMultiplosTresCinco = numeros.stream()
             .distinct()
             .filter(n -> n % 3 == 0 || n % 5 == 0).toList(); */

        Map<Boolean, List<Integer>> NumerosMultiplosDe3E5 = numeros.stream()
                .collect(Collectors.groupingBy(n -> (n % 3 == 0 || n % 5 == 0)));
        System.out.println(NumerosMultiplosDe3E5);


        System.out.println("\nDesafio 11 - Encontre a soma dos quadrados de todos os números da lista: ");
        List<Integer> somaQuadrados = numeros.stream().sorted().map(n -> n*n).toList();
        System.out.println(somaQuadrados);

        System.out.println("\nDesafio 12 - Encontre o produto de todos os números da lista: ");
        long produtoNumeros = numeros.stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(produtoNumeros);

        System.out.println("\nDesafio 13 - Filtrar os números que estão dentro de um intervalo: ");
        List<Integer> numerosEmIntervalo = numeros.stream()
                .sorted()
                .filter(n -> n >= 5 && n<= 10).toList();
        System.out.println(numerosEmIntervalo);

        System.out.println("\n Desafio 14 - Encontre o maior número primo da lista: ");
        Integer maiorPrimo = numeros.stream()
                .filter(Desafio::isPrimo)
                .max(Comparator.naturalOrder()).orElse(null);

        System.out.println(maiorPrimo);

        System.out.println("\nDesafio 15 - Verifique se a lista contém pelo menos um número negativo: ");
        System.out.println(numeros.stream().anyMatch(n -> n < 0));

        System.out.println("\nDesafio 16 - Agrupe os números em pares e ímpares: ");

        List<Integer> numerosPares = numeros.stream().distinct().filter(n-> n % 2 == 0).toList();
        List<Integer> numerosImpares = numeros.stream().distinct().filter(n-> n % 2 != 0).toList();
        System.out.println(numerosPares);
        System.out.println(numerosImpares);

        System.out.println("\nDesafio 17 - Filtrar os números primos da lista: ");
        List<Integer> numerosPrimos = numeros.stream()
                .distinct()
                .filter(Desafio::isPrimo).toList();
        System.out.println(numerosPrimos);

        System.out.println("\n18 - Verifique se todos os números da lista são iguais: ");

        Set<Integer> setNumeros = new HashSet<>();  // set para guardar primeira ocorrencia de cada numero
        List<Integer> numerosRepetidos = numeros.stream()  // percorre toda a lista
                .filter(n -> !setNumeros.add(n))  // filtra pelos que não são adicionados à setNumeros (repetidos)
                .toList();   // adiciona à nova lista os números repetidos
        System.out.println("números repetidos: " + numerosRepetidos);


        // Agrupa os números com base no próprio número.
        Map<Integer, List<Integer>> grupos = numeros.stream()
                .collect(Collectors.groupingBy(num -> num));
        // Você pode ver que temos a indicação quais são os números que se repetem observando chave - valor.
        System.out.println("Grupos de números: " + grupos);

        // Filtra os grupos com tamanho do valor maior que 1, logo, os números repetidos.
        List<Integer> nnumerosRepetidos = grupos.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1) // Filtamos as chaves pelos valores contendo acima de 1 repetição
                .map(entry -> entry.getKey()) // Pegamos apenas as chaves
                .toList(); // Coletamos para uma nova lista

        // Imprime os números repetidos.
        System.out.println("números repetidos: " + nnumerosRepetidos);
        System.out.println("Os números da lista são TODOS iguas? " + (nnumerosRepetidos.size() == 1));


        System.out.println("\nDesafio 19 - Encontre a soma dos números divisíveis por 3 e 5: ");
        int somaMultiplosDeTresECinco = numeros.stream()
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .reduce(0, Integer::sum);
        System.out.println(somaMultiplosDeTresECinco);

    }

    // Função que verifica se um número é primo
    public static boolean isPrimo(int n){
        // Verifica se o número é menor ou igual a 1, caso contrário, não é primo
        if (n<2){
            return false;
        }
        // Faz um loop de 2 até a raiz quadrada do número
        for (int i = 2; i * i <= n; i++){
            // Se o número for divisível por algum valor no intervalo, não é primo
            if(n % i == 0){
                return false;
            }
        }
        // Se não foi encontrado divisor no loop, o número é primo
        return  true;

    }
}
