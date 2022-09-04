#/bin/sh

cd $1
mvn test && git commit -anm "TDD TCR WIP" || git reset --hard
cd ..
