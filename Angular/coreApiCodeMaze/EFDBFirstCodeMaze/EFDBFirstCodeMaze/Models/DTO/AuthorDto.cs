using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EFDBFirstCodeMaze.Models.DTO
{
    public class AuthorDto
    {
        public AuthorDto()
        {
        }

        public long Id { get; set; }

        public string Name { get; set; }

        public AuthorContactDto AuthorContact { get; set; }
    }
}
