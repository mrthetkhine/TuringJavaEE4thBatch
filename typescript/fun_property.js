function getUnique()
{
    return getUnique.id ++;
}
getUnique.id = 0;

console.log("Unique ", getUnique());
console.log("Unique ", getUnique());