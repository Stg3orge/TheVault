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
    public class RobotFactoriesController : ControllerBase
    {
        private readonly DogDatabaseContext _context;

        public RobotFactoriesController(DogDatabaseContext context)
        {
            _context = context;
        }

        // GET: api/RobotFactories
        [HttpGet]
        public IEnumerable<RobotFactories> GetRobotFactories()
        {
            return _context.RobotFactories;
        }

        // GET: api/RobotFactories/5
        [HttpGet("{id}")]
        public async Task<IActionResult> GetRobotFactories([FromRoute] int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var robotFactories = await _context.RobotFactories.FindAsync(id);

            if (robotFactories == null)
            {
                return NotFound();
            }

            return Ok(robotFactories);
        }

        // PUT: api/RobotFactories/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRobotFactories([FromRoute] int id, [FromBody] RobotFactories robotFactories)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != robotFactories.RobotFactoryId)
            {
                return BadRequest();
            }

            _context.Entry(robotFactories).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RobotFactoriesExists(id))
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

        // POST: api/RobotFactories
        [HttpPost]
        public async Task<IActionResult> PostRobotFactories([FromBody] RobotFactories robotFactories)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _context.RobotFactories.Add(robotFactories);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRobotFactories", new { id = robotFactories.RobotFactoryId }, robotFactories);
        }

        // DELETE: api/RobotFactories/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRobotFactories([FromRoute] int id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var robotFactories = await _context.RobotFactories.FindAsync(id);
            if (robotFactories == null)
            {
                return NotFound();
            }

            _context.RobotFactories.Remove(robotFactories);
            await _context.SaveChangesAsync();

            return Ok(robotFactories);
        }

        private bool RobotFactoriesExists(int id)
        {
            return _context.RobotFactories.Any(e => e.RobotFactoryId == id);
        }
    }
}