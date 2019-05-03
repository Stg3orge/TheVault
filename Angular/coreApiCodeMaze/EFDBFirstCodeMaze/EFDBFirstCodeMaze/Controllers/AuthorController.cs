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
    public class AuthorController : ControllerBase
    {
        private readonly IDataRepository<Author, AuthorDto> dataRepository;

        public AuthorController(IDataRepository<Author, AuthorDto> dataRepository)
        {
            this.dataRepository = dataRepository;
        }

        // GET: api/Authors
        [HttpGet]
        public IActionResult Get()
        {
            var authors = dataRepository.GetAll();
            return Ok(authors);
        }

        // GET: api/Author/5
        [HttpGet("{id}")]
        public IActionResult GetAuthor([FromRoute] long id)
        {

            var author = dataRepository.GetDto(id);
            if (author == null)
            {
                return NotFound("Author not found.");
            }

            return Ok(author);

            //if (!ModelState.IsValid)
            //{
            //    return BadRequest(ModelState);
            //}

            //var author = await _context.Author.FindAsync(id);

            //if (author == null)
            //{
            //    return NotFound();
            //}

            //return Ok(author);
        }
    }
}