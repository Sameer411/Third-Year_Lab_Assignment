car1=read.csv(file.choose())
head(car1)
linear_mod <-lm(Diatance ~ Speed,data=car1)
print(linear_mod)
new.Speeds=data.frame(Speed=c(18,19,20))
predict(linear_mod,newdata=new.Speeds)
cor(car1 $Speed,car1 $ Diatance)
scatter.smooth(x=car1$Speed,
               y=car1$Diatance,
               xlab="Speed",
               ylab="Diatance",
               xlim=c(4,25),
               ylim=c(2,120),
                main="Speed vs Distance")
