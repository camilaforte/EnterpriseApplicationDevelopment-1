﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _07.FIAP.WEB.MVC.Models
{
    public class Time
    {

        public int TimeId { get; set; }
        public string Nome { get; set; }
        public bool Mundial { get; set; }

        // relacionamento
        public Tecnico Tecnico { get; set; }
        public int TecnicoId { get; set; }

        public IList<Jogador> Jogadores { get; set; }

        public IList<Campeonato> Campeonatos { get; set; }

    }
}