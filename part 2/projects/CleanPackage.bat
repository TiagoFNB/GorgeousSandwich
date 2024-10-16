cd eureka
	call mvnw clean package
cd ..
cd gateway
	call mvnw clean package
cd ..
cd PromotionManagement
	call mvnw clean package
cd ..
cd SandwichManagement
	call mvnw clean package
cd ..
cd ShopManagement
	call mvnw clean package
cd ..
cd UserManagement
	call mvnw clean package
cd ..
	call docker-compose up -d
pause