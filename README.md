# GorgeousSandwich
Project for ARQSOFT subject of the MSc in Software Engineering course at ISEP.

For academic purposes, the project consisted in two parts.
Part 1- Implement as monolith Springboot solution.
Part 2- Migrate the monolith solution to a microservices based one, that use Java (Springboot) and C# (.NET) for the microservices.

Each part documentation is avalaible in their respective folders.

## Project Context

GorgeousSandwich is a (fictional) sandwich shop brand that has multiple stores and needed a software that would allow them to manage different areas of their business.

Some of the focus areas of the software would be:

1. **Sandwich management**: Each sandwich has a designation, a selling price, and
multiple descriptions, although one per authorized language. The language is
to be detected by the application. The allowed languages must be changed in
a few seconds, but without impacting what was previously accepted. However,
descriptions should never be removed.
2. **Shop management**: A shop has a designation, an address, a person in charge,
and opening hours that may differ depending on the days of the week. The person
in charge has a name and an email.
3. **Order management**: A client can register sandwiches and their quantities for
delivery on a specifc day and shop. The total price is informed by the prototype.
Please note that a sandwich can never be sold below zero, despite the promotions
applied.
4. **Customer management**: A customer has a name, a tax identifcation number,
an address, an email and authentication data.
5. **Promotions management** : Global and local promotions can be specifed. While
global promotions apply to all stores, local promotion does not. Both types specify
percentages that apply as a discount to the unit price of specific products and have
a specified period for their application.
Promotions are reflected in the price according to different possibilities: only the
most favourable or local and global promotions are applied cumulatively. Switching from one possibility to another should be possible within seconds, without affecting what is fnished.

However, it should be noted that, for the prototype, only insertions and listings are
intended, with the specifed modifcation possibilities.

**NOTE**: Not all features described are implemented, and in part 1, the Order Management was not addressed.

