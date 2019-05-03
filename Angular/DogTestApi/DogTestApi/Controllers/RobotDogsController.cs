using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using DogTestApi.Models;

namespace DogTestApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RobotDogsController : ControllerBase
    {
        private readonly DogDatabaseContext _context;

        public RobotDogsController(DogDatabaseContext context)
        {
            _context = context;
        }

        // GET: api/RobotDogs
        [HttpGet]
        public IEnumerable<RobotDogs> GetRobotDogs()
        {
            return _context.RobotDogs;
        }

        // GET: api/RobotDogs/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetRobotDogs([FromRoute] int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var robotDogs = await _context.RobotDogs.FindAsync(id);

            if (robotDogs == null)
            {
                return NotFound();
            }

            return Ok(robotDogs);
        }

        // PUT: api/RobotDogs/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRobotDogs([FromRoute] int id, [FromBody] RobotDogs robotDogs)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != robotDogs.RobotDogId)
            {
                return BadRequest();
            }

            _context.Entry(robotDogs).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RobotDogsExists(id))
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

        // POST: api/RobotDogs
        [HttpPost]
        public async Task<IActionResult> PostRobotDogs([FromBody] RobotDogs robotDogs)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _context.RobotDogs.Add(robotDogs);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRobotDogs", new { id = robotDogs.RobotDogId }, robotDogs);
        }

        // DELETE: api/RobotDogs/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRobotDogs([FromRoute] int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var robotDogs = await _context.RobotDogs.FindAsync(id);
            if (robotDogs == null)
            {
                return NotFound();
            }

            _context.RobotDogs.Remove(robotDogs);
            await _context.SaveChangesAsync();

            return Ok(robotDogs);
        }

        private bool RobotDogsExists(int id)
        {
            return _context.RobotDogs.Any(e => e.RobotDogId == id);
        }
    }
}