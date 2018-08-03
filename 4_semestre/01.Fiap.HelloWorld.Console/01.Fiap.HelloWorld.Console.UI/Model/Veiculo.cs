using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Fiap.HelloWorld.Console.UI.Model
{


    class Veiculo
    {

        //Atributos
        private double _potencia; //todo atributo privado deve comecar com underline
        private readonly string _chassi; // o readonly permite que o valor seja atribuido apenas qdo da declaracao do atributo/variavel ou no construtor
    
        //Gets e Sets
        // se eu necessitar fazer alguma validacao preciso fazer o get e set dessa maneira abaixo
        public double Potencia
        {
            get { return _potencia; }
            set
            {
                if (value >= 0)
                {
                    _potencia = value;
                }
            }
        }

        // get e set sem a necessidade de validacao, se eu fizer assim eu NAO preciso criar o atributo
        public int Ano { get; set; }

    }

}
