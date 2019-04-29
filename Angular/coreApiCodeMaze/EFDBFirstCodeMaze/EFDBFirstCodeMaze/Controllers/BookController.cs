using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using EFDBFirstCodeMaze.Models;
using EFDBFirstCodeMaze.Models.Repository;
using EFDBFirstCodeMaze.Models.DTO;

namespace EFDBFirstCodeMaze.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BookController : ControllerBase
    {
        private readonly IDataRepository<Book, BookDto> dataRepository;

        public BookController(IDataRepository<Book, BookDto> dataRepository)
        {
            this.dataRepository = dataRepository;
        }

        // GET: api/Book/5
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var book = dataRepository.Get(id);
            if (book == null)
            {
                return NotFound("Book not found.");
            }

            return Ok(book);
        }
    }
}