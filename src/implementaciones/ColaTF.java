package implementaciones;

import api.ColaTDA;

public class ColaTF implements ColaTDA {
        private int[] vector;
        private int poner, sacar;

        @Override
        public void Inicializar() {
            vector = new int[101];
            poner = sacar = 0;
        }
        @Override
        public void Acolar(int x) {
            vector[poner] = x;
            poner += 1;
            if (poner == 101) {
                poner = 0;
            }
        }
        @Override
        public void Desacolar() {
            sacar += 1;
            if (sacar == 101) {
                sacar = 0;
            }
        }
        @Override
        public int Primero() {
            return vector[sacar];
        }

        @Override
        public boolean ColaVacia() {
            return sacar == poner;
        }
    }
