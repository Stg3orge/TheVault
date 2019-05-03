using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DNDNew.Models;

namespace DNDNew.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CharacterController : ControllerBase
    {
        private readonly DnD_databaseContext _context;

        public CharacterController(DnD_databaseContext context)
        {
            _context = context;
        }

        [HttpGet("Carl")]
        public async Task<ActionResult<IEnumerable<Character>>> GetDicks()
        {
            var data = _context.Character
                .Include(o => o.Hitpoints);
            return Ok(data);
        }

        // GET: api/Character
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Character>>> GetCharacter()
        {
            return await _context.Character.ToListAsync();
        }

        // GET: api/Character/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Character>> GetCharacter(int id)
        {
            var character = await _context.Character.FindAsync(id);

            if (character == null)
            {
                return NotFound();
            }

            return character;
        }

        // PUT: api/Character/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCharacter(int id, Character character)
        {
            if (id != character.Id)
            {
                return BadRequest();
            }

            _context.Entry(character).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CharacterExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Character
        [HttpPost]
        public async Task<ActionResult<Character>> PostCharacter(Character character)
        {
            _context.Character.Add(character);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetCharacter", new { id = character.Id }, character);
        }

        // DELETE: api/Character/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<Character>> DeleteCharacter(int id)
        {
            var character = await _context.Character.FindAsync(id);
            if (character == null)
            {
                return NotFound();
            }

            _context.Character.Remove(character);
            await _context.SaveChangesAsync();

            return character;
        }

        private bool CharacterExists(int id)
        {
            return _context.Character.Any(e => e.Id == id);
        }
    }
}
