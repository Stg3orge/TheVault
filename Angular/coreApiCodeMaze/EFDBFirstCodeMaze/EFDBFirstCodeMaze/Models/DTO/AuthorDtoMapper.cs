using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EFDBFirstCodeMaze.Models.DTO
{
    public static class AuthorDtoMapper
    {
        public static AuthorDto MapToDto(Author author)
        {
            return new AuthorDto()
            {
                Id = author.Id,
                Name = author.Name,

                AuthorContact = new AuthorContactDto()
                {
                    AuthorId = author.Id,
                    Address = author.AuthorContact.Address,
                    ContactNumber = author.AuthorContact.ContactNumber
                }
            };
        }
    }
}
