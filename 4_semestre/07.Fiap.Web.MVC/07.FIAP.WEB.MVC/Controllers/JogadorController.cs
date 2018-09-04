using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace _07.FIAP.WEB.MVC.Controllers
{
    public class JogadorController : Controller
    {
        // GET: Jogador
        public ActionResult Cadastrar()
        {
            return View();
        }
    }
}