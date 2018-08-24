using Fiap06.Wbe.MVC.Models;
using Fiap06.Wbe.MVC.Persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Fiap06.Wbe.MVC.Controllers
{
    public class AnimalController : Controller
    {

        private PetshopContext _context = new PetshopContext();

        // GET: Animal
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Cadastrar(Animal animal)
        {

            _context.Animais.Add(animal);
            _context.SaveChanges();

            return RedirectToAction("Cadastrar");
        }

    }

}