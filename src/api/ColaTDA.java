package api;

public interface ColaTDA {
    /* @tarea Inicializar inicializa la cola
     * */
    void Inicializar();

    /* @tarea Acolar agrega a la cola un elemento
     * @precondicion la cola tiene que estar preinicializada
     * */
    void Acolar(int x);

    /* @tarea Desacolar elimina un elemento como es una estructura FIFO se elimina el primero que se ingreso
     * @precondicion la estructura debe estar preinicializada y no puede estar vacia
     * */
    void Desacolar();

    /* @tarea Primero trae el primer elemento a eliminar es decir el primero que se ingreso
     * @precondicion la estructura debe estar preinicializada y no puede estar vacia
     * */

    int Primero();

    /* @tarea ColaVacia retorna true or false dependiendo si la cola esta vacia o no.
     * @precondicion la cola debe estar preinicializada.
     * */

    boolean ColaVacia();
}
