using Fiap.Banco.Model;
using Fiap.Exercicio1.UI.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    public class ContaCorrente : Conta
    {

        public TipoConta Tipo { get; set; }

        public override void Depositar(double valor)
        {
            Saldo = valor;
        }

        public override void Retirar(double valor)
        {

            if (Tipo == TipoConta.Comum && Saldo < valor)
            {
                throw new Exception("Saldo insuficiente.");
            }

            Saldo -= valor;

        }

    }
}
